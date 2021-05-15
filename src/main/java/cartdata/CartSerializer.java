package cartdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CartSerializer {

    public static void serialize(CartItems cartResult) {

        List<CartItems> cartResultList = CartDeserializer.deserialize();
        try {
            File file = new File("./test.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fileWriter);
            for(CartItems cartResult1: cartResultList){
                sequenceWriter.write(cartResult1);
            }
            sequenceWriter.write(cartResult);
            sequenceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
