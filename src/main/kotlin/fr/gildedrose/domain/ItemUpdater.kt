package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }

    item.sellIn = item.sellIn - 1
    item.increaseQualityBy(1)

    when {
      item.name == "Aged Brie" -> if (item.isSellInExpired()) {
        item.increaseQualityBy(1)
      }
      item.name == "Backstage passes to a TAFKAL80ETC concert" -> when {
        item.isSellInMedium() -> item.increaseQualityBy(1)
        item.isSellInLow() -> item.increaseQualityBy(2)
        item.isSellInExpired() -> item.decreaseQualityBy(item.quality)
      }
      else -> {
        item.decreaseQualityBy(2)
        if (item.isSellInExpired()) {
          item.decreaseQualityBy(1)
        }
      }
    }
  }
}