package cartdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.List;

public class CartItemsRepository {
    private static CartItemsRepository cartItemsRepository = null;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    private static final File cartFile = new File("./cartitems.json");

    private List<CartItems> cartItems;

    public static CartItemsRepository getInstance(){
        if(cartItemsRepository == null){
            cartItemsRepository = new CartItemsRepository();
        }
        return cartItemsRepository;
    }

    private CartItemsRepository() {
        try {
            if (!cartFile.exists()) {
                cartFile.createNewFile();
                cartItems = List.of();
            } else {
                loadGameResults(new FileInputStream(cartFile));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadGameResults(InputStream is){
        try{
            cartItems = OBJECT_MAPPER.readValue(is, new TypeReference<List<CartItems>>() {}); {
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void saveCart(CartItems cartItem){
        try {
            FileWriter fileWriter = new FileWriter(cartFile);

            SequenceWriter sequenceWriter = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValuesAsArray(fileWriter);
            for(CartItems cartItem1: cartItems){
                sequenceWriter.write(cartItem1);
            }
            sequenceWriter.write(cartItem);
            sequenceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CartItemsRepository cartItemsRepository = CartItemsRepository.getInstance();

    }
}
