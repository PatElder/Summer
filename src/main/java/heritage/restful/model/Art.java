package heritage.restful.model;

import org.hibernate.Criteria;

import java.math.BigDecimal;

public class Art {
    private int id;
    public Art(int id, String name, BigDecimal value) {
        id = this.id;
    }

    public Integer getId() {
        return id;
    }

}
