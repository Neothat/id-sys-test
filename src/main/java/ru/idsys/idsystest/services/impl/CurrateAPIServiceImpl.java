package ru.idsys.idsystest.services.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.services.CurrateAPIService;
import ru.idsys.idsystest.services.CurrencyPairService;
import ru.idsys.idsystest.services.ExchangeRateService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
public class CurrateAPIServiceImpl implements CurrateAPIService {

    private final int connectTimeout = 500;
    private final int readTimeout = 500;
    private final String baseURL = "https://currate.ru/api/?get=rates&pairs=";
    private final String key = "&key=21f5e04ab8729bc82e9d9e6a7e03aa07";

    private List<String> currencyPair;
    private String query;
    private HttpURLConnection connection;

    @Setter(onMethod = @__(@Autowired))
    @Getter
    private CurrencyPairService currencyPairService;

    @Setter(onMethod = @__(@Autowired))
    @Getter
    private ExchangeRateService exchangeRateService;

    @Override
    public void getRatesForCurrencies() {
        buildQuery();
        try {
            connectionSetup();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String jsonString;
                if ((jsonString = in.readLine()) != null) {
                    log.info("json received: " + jsonString);
                    JSONObject data = new JSONObject(jsonString).getJSONObject("data");
                    currencyPair.forEach(pair -> getExchangeRateService().save(
                            timestamp(),
                            data.getFloat(pair),
                            getCurrencyPairService().findByBaseCharAndQuotedChar(pair.substring(0, 3), pair.substring(3, 6)))
                    );
                }
            } else {
                log.error(String.format("Connection fail: %s, %s", connection.getResponseCode(), connection.getResponseMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private Timestamp timestamp() {
        String now = Long.toString(System.currentTimeMillis());
        return new Timestamp(Long.parseLong(now.substring(0, now.length() - 3) + "000"));
    }

    private void buildQuery() {
        currencyPair = getCurrencyPairService().getListCurrencyPair();
        query = baseURL + String.join(",", currencyPair) + key;
        log.info("Generated GET request: " + query);
    }

    private void connectionSetup() throws IOException {
        connection = (HttpURLConnection) new URL(query).openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());
        connection.setUseCaches(false);
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        connection.connect();
        log.info("Connection set up");
    }
}