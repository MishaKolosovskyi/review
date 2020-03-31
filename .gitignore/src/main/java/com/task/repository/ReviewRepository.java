package com.task.repository;

import com.task.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query(value = "SELECT PROFILENAME, count(*) AS ACTIVE FROM REVIEW " +
            "GROUP BY PROFILENAME " +
            "ORDER BY ACTIVE DESC " +
            "LIMIT :limit ;", nativeQuery = true)
    List<String> getMostActiveUsers(@Param("limit") int limit);

    @Query(value = "SELECT PRODUCTID, count(*) AS MOSTCOMMENTED FROM REVIEW " +
            "GROUP BY PRODUCTID " +
            "ORDER BY MOSTCOMMENTED DESC " +
            "LIMIT :limit ;", nativeQuery = true)
    List<String> getMostCommentedFood(@Param("limit") int limit);

    @Query(value = "SELECT TEXT FROM REVIEW", nativeQuery = true)
    List<String> getText();
}
