package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }

    item.sellIn = item.sellIn - 1
    item.increaseQualityBy(1)

    when {
      item.name == "Aged Brie" -> if (isSellInExpired()) {
        item.increaseQualityBy(1)
      }
      item.name == "Backstage passes to a TAFKAL80ETC concert" -> when {
        isSellInMedium() -> item.increaseQualityBy(1)
        isSellInLow() -> item.increaseQualityBy(2)
        isSellInExpired() -> item.decreaseQualityBy(item.quality)
      }
      else -> {
        item.decreaseQualityBy(2)
        if (isSellInExpired()) {
          item.decreaseQualityBy(1)
        }
      }
    }
  }

  private fun isSellInMedium() = item.sellIn < 10 && item.sellIn >= 5

  private fun isSellInLow() = item.sellIn < 5 && item.sellIn >= 0

  private fun isSellInExpired() = item.sellIn < 0
}