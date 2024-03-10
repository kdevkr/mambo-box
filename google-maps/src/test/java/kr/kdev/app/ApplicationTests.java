package kr.kdev.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.AddressType;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LocationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    static String apiKey = "";
    static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static GeoApiContext context;

    @BeforeAll
    static void contextLoads() {
        apiKey = System.getenv("GOOGLE_MAP_API_KEY");
        context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .queryRateLimit(10)
                .build();
    }

    @Test
    void Test_Places() {
        Assertions.assertDoesNotThrow(() -> {
            PlaceAutocompleteRequest.SessionToken session = new PlaceAutocompleteRequest.SessionToken();

            String input = "강남역";
            AutocompletePrediction[] predictions = PlacesApi.placeAutocomplete(context, input, session).await();

            System.out.println(gson.toJson(predictions));
            context.shutdown();
        });
    }

    @Test
    void Test_Geocoding() {
        Assertions.assertDoesNotThrow(() -> {
            String address = "강남역";
            GeocodingResult[] results =  GeocodingApi.geocode(context, address)
                    .language("ko")
                    .locationType(LocationType.ROOFTOP)
                    .resultType(AddressType.STREET_ADDRESS)
                    .await();

            System.out.println(gson.toJson(results));

            // Invoke .shutdown() after your application is done making requests
            context.shutdown();
        });
    }

}
