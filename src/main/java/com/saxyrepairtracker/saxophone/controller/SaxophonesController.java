//package com.saxyrepairtracker.saxophone.controller;
//
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Stream;
//
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.saxyrepairtracker.saxophone.entity.SaxophoneType;
//import com.saxyrepairtracker.saxophone.entity.Saxophones;
//
//
//
//@Nested
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//@Sql(
//    scripts = {"Saxophone repair.sql", 
//                "Saxophone repair data.sql"}, 
//          config = @SqlConfig(encoding = "utf-8"))
//
//class SaxophonesController {
//
//  class TestThatDoNotPolluteTheApplicationContext extends FetchSaxophonesTestSupport {
//    /**
//     * 
//     */
//    @Test
//    void testThatJeepsAreReturnedWhenAValidModelModelAndTrimAreSupplied() {
//       // Given: a valid model, trim, and URI
//      SaxophoneType model = SaxophoneType.TENOR;
//      String trim = "Sport";
//      String uri = 
//          String.format("%s?model=%s&trim=%s", getBaseUriForSaxophones(), model, trim);
//    
//       // When: a connection is made to the URI
//       ResponseEntity<List<Saxophones>> response = getRestTemplate().exchange(uri, 
//               HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
//    
//       // Then: a not found (404) status code is returned
//       assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); 
//    
//       // And: an error message is returned
//       List<Saxophones> actual = response.getBody();
//       List<Saxophones> expected = buildExpected();
//       
//       assertThat(actual).isEqualTo(expected);
//    }
//    
//    /**
//     * 
//     */
//     Test for error message
//    @Test
//    void testThatAnErrorMessageIsReturnedWhenAnUnknownTrimIsSupplied() {
//       // Given: a valid model, trim, and URI
//      SaxophoneType type = SaxophoneType.TENOR;
//      String trim = "Unknown Value";
//      String uri = 
//          String.format("%s?model=%s&trim=%s", getBaseUriForSaxophones(), type, trim);
//    
//       // When: a connection is made to the URI
//       ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, 
//               HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
//    
//       // Then: a not found (404) status code is returned
//       assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND); 
//    
//       // And: an error message is returned
//       Map<String, Object> error = response.getBody();
//       
//       assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
//    }
//
//    /**
//     * 
//     */
//    // Test for invalid value message
//    @ParameterizedTest
//    @MethodSource("com.saxyrepairtracker.saxophone.controller.FetchSaxophoneTest#parametersForInvalidInput")
//    void testThatAnErrorMessageIsReturnedWhenAnInvalidValueIsSupplied(
//        String model, String trim, String reason) {
//       // Given: a valid model, trim, and URI
//      String uri = 
//          String.format("%s?model=%s&trim=%s", getBaseUriForSaxophones(), model, trim);
//    
//       // When: a connection is made to the URI
//       ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, 
//               HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
//    
//       // Then: a not found (404) status code is returned
//       assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST); 
//    
//       // And: an error message is returned
//       Map<String, Object> error = response.getBody();
//       
//       assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
//    }
//  }
//
//    static Stream<Arguments> parametersForInvalidInput() {
//      // @formatter:off
//      return Stream.of(
//          arguments("WRANGLER", "@#$%^&&%", "Trim constains non-alpha-numeric chars"),
//          arguments("WRANGLER", "C".repeat(Constants.TRIM_MAX_lENGTH +1), "Trim length to long"),
//          arguments("INVALID", "SPORT", "Model is not enum value")
//      // @ formatter:on    
//          );
//  }
//  
//  @Nested
//  @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//  @ActiveProfiles("test")
//  @Sql(
//      scripts = {"Saxophone repair.sql", 
//                  "Saxophone repair data.sql"}, 
//            config = @SqlConfig(encoding = "utf-8"))
//  class TestThatPolluteTheApplicationContext extends FetchSaxophonesTestSupport {
//    @MockBean
//    private Saxophones saxophones;
//    
//    /**
//     * 
//     */
//    // Test for error message
//    @Test
//    void testThatUnplannedErrorResultsInA500Status() {
//       // Given: a valid model, trim, and URI
//      SaxophoneType type = SaxophoneType.TENOR;
//      String trim = "Invalid";
//      String uri = 
//          String.format("%s?model=%s&trim=%s", getBaseUriForSaxophones(), type, trim);
//    
//      doThrow(new RuntimeException("Ouch!")).when(Saxophones)
//        .fetchJeeps(type, trim);
//      
////        When: a connection is made to the URI
//              ResponseEntity<Map<String, Object>> response = 
//              getRestTemplate().exchange(
//                  uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
//      
//       // Then: an internal server error (500) status is returned
//       assertThat(response.getStatusCode())
//           .isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR); 
//    
//       // And: an error message is returned
//       Map<String, Object> error = response.getBody();
//       
//       assertErrorMessageValid(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
// 
//}