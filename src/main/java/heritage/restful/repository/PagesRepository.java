package heritage.restful.repository;


import heritage.restful.model.Pages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesRepository extends JpaRepository<Pages, Long> {
}
