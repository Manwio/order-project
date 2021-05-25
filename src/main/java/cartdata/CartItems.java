package cartdata;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class CartItems {

    @JsonProperty("orderCode") private String code;

    @JsonProperty("name") private String name;

    @JsonProperty("address") private String address;

    @JsonProperty("pizza") private String pizza;

    @JsonProperty("allergen") private String allergen;

    @JsonProperty("pay") double pay;

}
