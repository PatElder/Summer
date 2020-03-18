package heritage.restful.repository;

import heritage.restful.model.Art;
import heritage.restful.service.ArtService;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArtRepository {
    private static final ArtRepository INSTANCE = new ArtRepository();
    private final Map<Integer,Art> piecesById;


    public static ArtRepository getInstance() {
        return INSTANCE;
    }
    private ArtRepository() {

        super();

        this.piecesById = new LinkedHashMap<Integer, Art>();


        final Art piece1 = new Art(1, "Salvator Mundi", new BigDecimal("469700000.00"));
        this.piecesById.put(piece1.getId(), piece1);
        //piece1.getComments().add(new Comment(1, "I'm so sad this piece is not in a museum!"));
    }
    public List<Art> findAll() {
        return new ArrayList<Art>(this.piecesById.values());
    }

    public Art findById(final Integer id) {
        return this.piecesById.get(id);
    }

}
