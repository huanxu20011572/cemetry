package com.topsuntech.gUnit_gmgl.gEU_system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.topsuntech.gUnit_gmgl.core.tree.TreeNode;


/**
 * The persistent class for the DICT database table.
 * 
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Dict extends TreeNode<Dict>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -133585540473647926L;
	private Long id;
	private String dictCode;
	private String dictName;
	private Long isValidate;
	private String remark;
	private Long sort;

	public Dict() {
	}


	@Id
	@SequenceGenerator(name="DICT_ID_GENERATOR", allocationSize = 1,sequenceName="DICT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DICT_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="DICT_CODE")
	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}


	@Column(name="DICT_NAME")
	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}


	@Column(name="IS_VALIDATE")
	public Long getIsValidate() {
		return this.isValidate;
	}

	public void setIsValidate(Long isValidate) {
		this.isValidate = isValidate;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Column(name="\"SORT\"")
	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@Override
	@OrderBy(value = "sort")
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="parent")
	public List<Dict> getChildren() {
		// TODO Auto-generated method stub
		return this.children;
	}


	@Override
	public void setChildren(List<Dict> children) {
		this.children = children;
		
	}


	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PID")
	public Dict getParent() {
		return this.parent;
	}


	@Override
	public void setParent(Dict parent) {
		this.parent = parent;
		
	}


	@Override
	@Transient
	public String getState() {
		if(!isLeaf()){
			return "closed";
		}
		return null;
	}


	@Override
	@Transient
	public String getText() {
		return this.dictName;
	}

}