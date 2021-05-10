package orderapp.cart;

import util.jpa.GenericJpaDao;

import javax.transaction.Transactional;
import java.util.List;

/**
 * DAO class for the CartItems entity.
 */
public class CartItemsDao extends GenericJpaDao<CartItems> {

    /**
     * The constructor that accepts no arguments.
     */
    public CartItemsDao() {
        super(CartItems.class);
    }

    /**
     * Returns the list of all results with respect to the number of steps
     * and the time spent for playing the game.
     *
     * @return the list of all results with respect to the number of steps
     * and the time spent for playing the game
     */
    @Transactional
    public List<CartItems> findAll() {
        return entityManager.createQuery("SELECT c.pizza, c.cost FROM CartItems AS c", CartItems.class).getResultList();
    }
}