package heritage.restful.service;

import heritage.restful.model.Art;
import heritage.restful.repository.ArtRepository;

import java.util.List;

public class ArtService {
    public List<Art> findAll() {
        return ArtRepository.getInstance().findAll();
    }
    public Art findById(int id) {
        return ArtRepository.getInstance().findById(id);
    }

}
