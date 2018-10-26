package com.pretzel.pretzelEShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretzelRepository extends JpaRepository<Pretzel, Long> {

}
