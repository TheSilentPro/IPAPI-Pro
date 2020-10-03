# IPAPI-Pro
Library for the Pro endpoint for ip-api.com

This is works exacly like the [IPAPI](https://github.com/TheSilentPro/IPAPI)
The only differance is that this contains features like SSL(HTTPS) and removes the getResetTime and getRequestsLeft.

### Dependencies
[json-simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple)

### Installation
You may download it from the [Releases Page](https://github.com/TheSilentPro/IPAPI-Pro/releases) <br>
You can also you [JitPack](https://jitpack.io/#TheSilentPro/IPAPI-Pro)

### Usage
```
Response response = new Builder("1.1.1.1")
      .all() // Adds all fields to the request
      .build() // builds the request
      .makeRequest(); // Makes the request to the API with the builded request
Set<Map.Entry<Field, String>> list = response.getResponses(); // Get a list of responses for the requested fields
String value = response.getValue(field); // Get the value of a field
```

### Example
Getting the status, country, and city
```
        Response response = new Builder("1.1.1.1")
                .withStatus()
                .withCountry()
                .withCity()
                .build().makeRequest();
        String status = response.getValue(Field.STATUS);
        String country = response.getValue(Field.COUNTRY);
        String city = response.getValue(Field.CITY);
        System.out.println("Status: " + status);
        System.out.println("Country: " + country);
        System.out.println("City: " + city);
```

Getting all fields and printing them
```java
    public static void main(String[] args) throws IOException, ParseException {
        Response response = new Builder("1.1.1.1")
                .all()
                .build().makeRequest();

        for (Map.Entry<Field, String> f : response.getResponses()) {
            System.out.println(f.getKey().getName() + ": " + f.getValue());
        }
    }
```

### [LICENSE](https://github.com/TheSilentPro/IPAPI-Pro/blob/master/LICENSE)
This API is licensed under GNU General Public License v3.0
