package com.quiz.app.repository;

import com.quiz.app.entity.UserRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshToken,Integer> {
    Optional<UserRefreshToken> findByRefreshId(String refreshId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserRefreshToken u WHERE u.userInfo.id = :userId")
    void deleteByUserId(Integer userId);
}
