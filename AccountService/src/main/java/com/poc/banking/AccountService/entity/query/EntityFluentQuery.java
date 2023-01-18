package com.poc.banking.AccountService.entity.query;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public class EntityFluentQuery<T> implements FetchableFluentQuery<T>{
	FetchableFluentQuery<T> queryFunction;
	public EntityFluentQuery(EntityFluentQuery queryFunction) {
		this.queryFunction = queryFunction;
	}
	
	@Override
	public FetchableFluentQuery<T> sortBy(Sort sort) {
		// TODO Auto-generated method stub
		return this.queryFunction.sortBy(sort);
	}

	@Override
	public <R> FetchableFluentQuery<R> as(Class<R> resultType) {
		// TODO Auto-generated method stub
		return this.queryFunction.as(resultType);
	}

	@Override
	public FetchableFluentQuery<T> project(Collection<String> properties) {
		// TODO Auto-generated method stub
		return this.queryFunction.project(properties);
	}

	@Override
	public T oneValue() {
		// TODO Auto-generated method stub
		return this.queryFunction.oneValue();
	}

	@Override
	public T firstValue() {
		// TODO Auto-generated method stub
		return this.queryFunction.firstValue();
	}

	@Override
	public List<T> all() {
		// TODO Auto-generated method stub
		return this.queryFunction.all();
	}

	@Override
	public Page<T> page(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.queryFunction.page(pageable);
	}

	@Override
	public Stream<T> stream() {
		// TODO Auto-generated method stub
		return this.queryFunction.all().stream();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.queryFunction.count();
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return this.queryFunction.exists();
	}

}
