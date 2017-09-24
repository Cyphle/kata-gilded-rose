package fr.gildedrose.domain

class ItemUpdater(var item: Item) {
  fun updateQuality() {
    if (item.name == "Sulfuras, Hand of Ragnaros") {
      return
    }

    item.sellIn = item.sellIn - 1
    item.increaseQualityBy(1)
    item = ItemAction.findItemByName(item.name).action(item)
  }
}