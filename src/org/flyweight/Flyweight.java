/**
 * 享元模式：是为了避免大量的细粒度对象占用系统的内存单元，比如String
 * 包含抽象享元、具体享元、享元工厂(会检查是否已经含有具体想说来决定创建新的对象)
 */
package org.flyweight;

public interface Flyweight {

	//state是外部状态
	public void operation(String state);
}
