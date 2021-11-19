package com.work.space.repository.company;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class Company implements CompanyRepository{
    @Override
    public Optional<com.work.space.entity.Company> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<com.work.space.entity.Company> findAll() {
        return null;
    }

    @Override
    public List<com.work.space.entity.Company> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<com.work.space.entity.Company> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<com.work.space.entity.Company> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(com.work.space.entity.Company entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends com.work.space.entity.Company> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends com.work.space.entity.Company> S save(S entity) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends com.work.space.entity.Company> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<com.work.space.entity.Company> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public com.work.space.entity.Company getOne(Integer integer) {
        return null;
    }

    @Override
    public com.work.space.entity.Company getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends com.work.space.entity.Company> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends com.work.space.entity.Company> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends com.work.space.entity.Company> boolean exists(Example<S> example) {
        return false;
    }
}
