package tsp.ipapi;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * API for the pro endpoint for ip-api.com
 * Dependency: json-simple -> https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
 *
 * @author TheSilentPro
 * @version 1.0
 */
public class IPAPI {

    public static void main(String[] args) throws IOException, ParseException {
        Response response = new Builder("1.1.1.1")
                .useSSL()
                .all()
                .build().makeRequest();
        for (Map.Entry<Field, String> field : response.getResponses()) {
            System.out.println(field.getKey().getName() + ": " + field.getValue());
        }
    }

    /**
     * Base URL for checking ips
     */
    private static String protocol = "http";
    private static String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "://pro.ip-api.com/json/";

    public static class Builder {

        private final String ip;
        private String lang = "en";
        private final Map<tsp.ipapi.Field, Boolean> fields = new HashMap<>();

        public Builder(String ip) {
            this.ip = ip;
        }

        public Builder withKey(String key) {
            API_KEY = key;
            return this;
        }

        public Builder withStatus() {
            fields.put(tsp.ipapi.Field.STATUS, true);
            return this;
        }

        public Builder withMessage() {
            fields.put(tsp.ipapi.Field.MESSAGE, true);
            return this;
        }

        public Builder withContinent() {
            fields.put(tsp.ipapi.Field.CONTINENT, true);
            return this;
        }

        public Builder withContinentCode() {
            fields.put(tsp.ipapi.Field.CONTINENT_CODE, true);
            return this;
        }

        public Builder withCountry() {
            fields.put(tsp.ipapi.Field.COUNTRY, true);
            return this;
        }

        public Builder withCountryCode() {
            fields.put(tsp.ipapi.Field.COUNTRY_CODE, true);
            return this;
        }

        public Builder withRegion() {
            fields.put(tsp.ipapi.Field.REGION, true);
            return this;
        }

        public Builder withRegionName() {
            fields.put(tsp.ipapi.Field.REGION_NAME, true);
            return this;
        }

        public Builder withCity() {
            fields.put(tsp.ipapi.Field.CITY, true);
            return this;
        }

        public Builder withDistrict() {
            fields.put(tsp.ipapi.Field.DISTRICT, true);
            return this;
        }

        public Builder withZip() {
            fields.put(tsp.ipapi.Field.ZIP, true);
            return this;
        }

        public Builder withLatitude() {
            fields.put(tsp.ipapi.Field.LATITUDE, true);
            return this;
        }

        public Builder withLongitude() {
            fields.put(tsp.ipapi.Field.LONGITUDE, true);
            return this;
        }

        public Builder withTimezone() {
            fields.put(tsp.ipapi.Field.TIMEZONE, true);
            return this;
        }

        public Builder withOffset() {
            fields.put(tsp.ipapi.Field.OFFSET, true);
            return this;
        }

        public Builder withCurrency() {
            fields.put(tsp.ipapi.Field.CURRENCY, true);
            return this;
        }

        public Builder withInternetServiceProvider() {
            fields.put(tsp.ipapi.Field.INTERNET_SERVICE_PROVIDER, true);
            return this;
        }

        public Builder withOrganization() {
            fields.put(tsp.ipapi.Field.ORGANIZATION, true);
            return this;
        }

        public Builder withAs() {
            fields.put(tsp.ipapi.Field.AS, true);
            return this;
        }

        public Builder withAsName() {
            fields.put(tsp.ipapi.Field.AS_NAME, true);
            return this;
        }

        public Builder withReverse() {
            fields.put(tsp.ipapi.Field.REVERSE, true);
            return this;
        }

        public Builder withMobile() {
            fields.put(tsp.ipapi.Field.MOBILE, true);
            return this;
        }

        public Builder withProxy() {
            fields.put(tsp.ipapi.Field.PROXY, true);
            return this;
        }

        public Builder withHosting() {
            fields.put(tsp.ipapi.Field.HOSTING, true);
            return this;
        }

        public Builder withQuery() {
            fields.put(tsp.ipapi.Field.QUERY, true);
            return this;
        }

        public Builder all() {
            for (Field field : Field.values()) {
                fields.put(field, true);
            }
            return this;
        }

        public Builder withLanguage(String language) {
            this.lang = language;
            return this;
        }

        public Builder useSSL() {
            protocol = "https";
            return this;
        }

        public tsp.ipapi.Response build() throws IOException {
            if (API_KEY.equals("YOUR_API_KEY")) throw new NullPointerException("Please change the API Key or use 'withKey(key)'!");
            String req = protocol + BASE_URL + ip + "?fields=";
            StringBuilder builder = new StringBuilder();
            int index = 0;
            for (Map.Entry<tsp.ipapi.Field, Boolean> map : fields.entrySet()) {
                if (map.getValue()) {
                    index++;
                    builder.append(map.getKey().getName());
                    if (fields.keySet().size() > index) {
                        builder.append(",");
                    }

                }
            }
            req = req + builder.toString() + "&lang=" + lang + "&key=" + API_KEY;
            return new tsp.ipapi.Response(new URL(req));
        }

    }

}
