package orderapp.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class CartItems {
    /**
     * The id of the result in database.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * The name of the order.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The address of the order.
     */
    @Column(nullable = false)
    private String address;

    /**
     * The pizza datas.
     */
    @Column(nullable = false)
    private String pizza;

    /**
     * The pizza cost:
     */
    @Column(nullable = false)
    private String cost;

}