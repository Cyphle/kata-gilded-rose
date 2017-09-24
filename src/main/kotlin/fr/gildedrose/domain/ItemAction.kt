package fr.gildedrose.domain

enum class ItemAction(val itemName: String, val action: (item: Item) -> Item) {
  AGED_BRIE("Aged Brie", { item ->
    if (item.isSellInExpired()) item.increaseQualityBy(1)
    item
  }),
  BACKSTAGE("Backstage passes to a TAFKAL80ETC concert", { item ->
    when {
      item.isSellInMedium() -> item.increaseQualityBy(1)
      item.isSellInLow() -> item.increaseQualityBy(2)
      item.isSellInExpired() -> item.decreaseQualityBy(item.quality)
    }
    item
  }),
  DEFAULT("default", { item ->
    item.decreaseQualityBy(2)
    if (item.isSellInExpired()) item.decreaseQualityBy(1)
    item
  });

  companion object {
    fun findItemByName(name: String): ItemAction {
      return values()
              .find { it.itemName.toLowerCase() == name.toLowerCase() } ?: ItemAction.DEFAULT
    }
  }
}