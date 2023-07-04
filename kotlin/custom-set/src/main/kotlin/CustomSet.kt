class CustomSet(vararg items: Int) {

    val _items = items.toMutableList()

    // TODO: implement proper constructor

    fun isEmpty(): Boolean {
        return _items.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return _items.size <= other._items.size
                && _items.all { other._items.contains(it) }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return (other._items.size == 0 || _items.size == 0) || _items.none { other._items.contains(it) }
    }

    fun contains(other: Int): Boolean {
        return _items.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return _items.filter { other._items.contains(it) }.let { CustomSet(*it.toIntArray()) }
    }

    fun add(other: Int) {
        if (!_items.contains(other))
            _items.add(other)
    }

    override fun equals(other: Any?): Boolean {
        return other is CustomSet
                && other._items.size == _items.size
                && other._items.all { _items.contains(it) }
    }

    operator fun plus(other: CustomSet): CustomSet {
        val result = other._items.filter { !_items.contains(it) } + _items
        return CustomSet(*result.toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {
        return _items.filter { !other._items.contains(it) }.let { CustomSet(*it.toIntArray()) }
    }
}
