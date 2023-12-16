package com.quiz.app.service;

import com.quiz.app.entity.UserRefreshToken;
import com.quiz.app.repository.UserInfoRepository;
import com.quiz.app.repository.UserRefreshTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class RefreshTokenService {

    @Autowired
    private UserRefreshTokenRepository userRefreshTokenRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserRefreshToken createRefreshToken(Integer userId) {
        deleteRefreshTokenByUserId(userId);
        UserRefreshToken userRefreshToken = UserRefreshToken.builder()
                .userInfo(userInfoRepository.findById(userId).get())
                .refreshId(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(60_000))//10
                .build();
        return userRefreshTokenRepository.save(userRefreshToken);
    }

    public void deleteRefreshTokenByUserId(Integer userId){
        userRefreshTokenRepository.deleteByUserId(userId);
    }


    public Optional<UserRefreshToken> findByToken(String token) {
        return userRefreshTokenRepository.findByRefreshId(token);
    }


    public boolean isExpired(UserRefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            userRefreshTokenRepository.delete(token);
            log.info("Refresh token was expired. Please make a new signin request");
            return true;
        }
        return false;
    }

}
