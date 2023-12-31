package com.ryan9025.myhomepage.repository;

import com.ryan9025.myhomepage.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer> {
    @Modifying
    @Query(value = "INSERT INTO LIKES(id,imageID,memberID,createDate) " +
            "VALUES(LIKES_SEQ.nextval, :imageID, :customDetailsID, sysdate)", nativeQuery = true)
    int like(@Param("imageID") int imageID, @Param("customDetailsID") int customDetailsID);

    @Modifying
    @Query(value = "DELETE FROM LIKES WHERE imageID = :imageID AND memberID = :customDetailsID", nativeQuery = true)
    int hate(@Param("imageID") int imageID, @Param("customDetailsID") int customDetailsID);
}
