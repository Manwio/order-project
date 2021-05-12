package cartdata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemsSave {
    private String orderName;

    private String orderAddress;

    private String pizzaItems;

    private String payVal;
}