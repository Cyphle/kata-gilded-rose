package fr.gildedrose.domain

class ItemUpdater(var item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }

    item.sellIn = item.sellIn - 1
    item.increaseQualityBy(1)

    if (item.name == "Aged Brie") {
      item = ItemAction.findItemByName(item.name).action(item)
    } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") when {
      item.isSellInMedium() -> item.increaseQualityBy(1)
      item.isSellInLow() -> item.increaseQualityBy(2)
      item.isSellInExpired() -> item.decreaseQualityBy(item.quality)
    }
    else {
      item.decreaseQualityBy(2)
      if (item.isSellInExpired()) {
        item.decreaseQualityBy(1)
      }
    }
  }
}

enum class ItemAction(val itemName: String, val action: (item: Item) -> Item) {
  AGED_BRIE("Aged Brie", { item ->
    if (item.isSellInExpired()) item.increaseQualityBy(1)
    item
  }),
  DEFAULT("default", { item ->
    item.decreaseQualityBy(2)
    if (item.isSellInExpired()) item.decreaseQualityBy(1)
    item
  });

  companion object {
    fun findItemByName(name: String): ItemAction {
      val itemAction = ItemAction.values().filter { it.itemName.toLowerCase() == name.toLowerCase() }
      return if (itemAction.isEmpty())
        ItemAction.DEFAULT
      else
        itemAction.first()
    }
  }
}