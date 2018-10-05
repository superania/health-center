package healthCenter.repository;

import healthCenter.entity.Office;
import healthCenter.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author ania
 */
public interface OfficeRepository extends JpaRepository<Office,Long>{



    @Query("select distinct o from Office o left join o.visits v " +
            " where " +
            " (v.date = :date and " +
            " ((select max(v.timeTo) from v) < :from1 or " +
            " (select min(v.timeFrom) from v)  > :to)) ")
    List<Office> findFreeOffice1(@Param("from1") LocalTime timeFrom,
                                 @Param("to") LocalTime timeTo,
                                 @Param("date") LocalDate date);

    Office findById(Long id);

}
