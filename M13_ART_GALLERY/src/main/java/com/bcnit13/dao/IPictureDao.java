package com.bcnit13.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnit13.dto.Picture;

@Repository
@Transactional
public interface IPictureDao extends JpaRepository<Picture, Long> {


}
