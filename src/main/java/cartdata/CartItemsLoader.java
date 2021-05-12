package cartdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CartItemsLoader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static CartItemsSave loadCart(File saveCartFile){
        try {
            return OBJECT_MAPPER.readValue(new FileInputStream(saveCartFile), new TypeReference<CartItemsSave>() {});

        }catch(IOException e){
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static void saveCart(CartItemsSave cartSave){
        try {
            File file = new File(System.getProperty("user.dir")
                    +File.separator+"foxcatcher-save-"
                    + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))+".json");
            file.createNewFile();

            OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(file, cartSave);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CartItemsSave cartItemsSave = CartItemsLoader.loadCart(new File("./foxcatcher-save-2021-05-11-20-30-40.json"));

        System.out.println(cartItemsSave.toString());
    }
}
