package com.poc.banking.UserService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public class EntityFluentQuery<T> implements FluentQuery.FetchableFluentQuery<T> {

	FluentQuery.FetchableFluentQuery<T> queryFunction;
	public EntityFluentQuery(FluentQuery.FetchableFluentQuery<T> queryFunction) {
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
		System.out.println("@Ramesh first value" + this.queryFunction.all().size());

		return this.queryFunction.all().get(0);
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
		System.out.println("@Ramesh exists" + this.queryFunction.all().size());
		return this.queryFunction.all().size() > 0;
	}
		
}
