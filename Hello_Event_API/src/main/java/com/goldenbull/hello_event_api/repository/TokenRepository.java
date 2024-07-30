package com.goldenbull.hello_event_api.repository;

import com.goldenbull.hello_event_api.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query("""
select t from Token t inner join t.user u
where t.user.userId = :userId and t.loggedOut = false
""")
    List<Token> findAllTokensByUser(Long userId);

    Optional<Token> findByToken(String token);
}
