package com.lgcns.tct.category;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Category {
	/**
	 * 상위 카테고리를 검색하는 기능
	 *
     * @param		inputData		String[][]		입력데이터(카테고리 정보)
     * @param		categories		List			입력데이터(inputCategories[0]: 카테고리1, inputCategories[1]: 카테고리2)
     * @return						String 			상위 카테고리
	 */
	
	
	private Item item = new Item();
	
	public String getTopCategory(String[][] inputData, List<String> categories) {
		String topCategory = "";
		////////////////////////여기부터 구현 (1) ---------------->
		
		this.item.setId(inputData[0][0]);
		for(String[] input : inputData) {
			Item tmp = new Item();
			tmp.setId(input[1]);
			
			Item parent = this.item.findItem(input[0]);
			tmp.setParent(parent);
			parent.addChild(tmp);
			tmp.depth();
			
		}
		Set<Item> parents = new HashSet<Item>();
		for(String i : categories) {
			Item findItem = item.findItem(i);
			List<Item> p = findItem.getParents();
			parents.addAll(p);
		}

		
		for(String i : categories) {
			Item findItem = item.findItem(i);
			List<Item> p = findItem.getParents();
			parents.retainAll(p);
		}
		Item max = null;
		for(Item item : parents) {
			if(max == null) {
				max = item;
			} else {
				if(max.getDepth() < item.getDepth()) {
					max = item;
				}
			}
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return max.getId();
	}
	
	private static class Item {
		private String id;
		private Item parent;
		private List<Item> children = new ArrayList<Item>();
		
		private int depth;
		
		public void depth() {
			this.depth = this.parent.getDepth() + 1;
		}
		
		public String toString() {
//			String p = this.parent.getId() == null ? "" : this.parent.getId();
			String ch = this.id;
			return ch;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Item getParent() {
			return parent;
		}
		public void setParent(Item parent) {
			this.parent = parent;
		}
		public List<Item> getChildren() {
			return children;
		}
		public void setChildren(List<Item> children) {
			this.children = children;
		}
		
		public void addChild(Item item) {
			this.children.add(item);
		}
		
		public Item findItem(String id) {
			Item ret = null;
			if(this.id.equals(id)) {
				ret = this;
			} else {
				for(Item t : this.children) {
					ret = t.findItem(id); 
					if(ret != null) {
						break;
					}
				}
			}
			return ret;
		}
		
		public List<Item> getParents() {
			List<Item> p = new ArrayList<Item>();
			if(this.getParent() != null) {
				p.add(this.getParent());
				p.addAll(this.parent.getParents());
			}
					
			return p;
			
		}
		
		public List<Item> getChildrenAll() {
			List<Item> ret = new LinkedList<Item>();
			ret.addAll(this.children);
			for(Item item : this.children) {
				ret.addAll(item.getChildrenAll());
			}
			return ret;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}
		
	}
	
	/**
	 * 하위 카테고리의 개수를 계산하는 기능
	 *
     * @param		inputData		String[][]		입력데이터(카테고리 정보)
     * @param		categoryStr		String			입력데이터(카테고리)
     * @return						int 			하위 카테고리의 개수
	 */
	public int getNumberOfSubcategories(String[][] inputData, String categoryStr) {
		int numberOfSubcategories = 0;
		////////////////////////여기부터 구현 (2) ---------------->
		List<Item> childrenAll = this.item.findItem(categoryStr).getParent().getChildrenAll();
		///////////////////////////// <-------------- 여기까지 구현 (2)
		
		return childrenAll.size();
	}

	
}