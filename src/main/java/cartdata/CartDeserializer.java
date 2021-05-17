package cartdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartDeserializer {

    public static List<CartItems> deserialize(){
        List<CartItems> cartResultList = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("./order.json");
            if(!file.exists()) {
                file.createNewFile();
                return List.of();
            }

            cartResultList = mapper.readValue(
                    file, new TypeReference<List<CartItems>>() { });

        }catch(IOException e){
            e.printStackTrace();
        }
        return cartResultList;
    }
}
