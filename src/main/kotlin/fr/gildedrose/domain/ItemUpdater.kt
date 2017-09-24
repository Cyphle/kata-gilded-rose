package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }

    item.sellIn = item.sellIn - 1
    increaseQualityBy(1)

    when {
      item.name == "Aged Brie" -> if (isSellInExpired()) {
        increaseQualityBy(1)
      }
      item.name == "Backstage passes to a TAFKAL80ETC concert" -> when {
        isSellInMedium() -> increaseQualityBy(1)
        isSellInLow() -> increaseQualityBy(2)
        isSellInExpired() -> decreaseQuality(item.quality)
      }
      else -> {
        decreaseQuality(2)
        if (isSellInExpired()) {
          decreaseQuality(1)
        }
      }
    }
  }

  private fun isSellInMedium() = item.sellIn < 10 && item.sellIn >= 5

  private fun isSellInLow() = item.sellIn < 5 && item.sellIn >= 0

  private fun isSellInExpired() = item.sellIn < 0

  private fun decreaseQuality(value: Int) {
    var decreaseLevel = value
    while (decreaseLevel > 0) {
      if (item.quality > 0) {
        item.quality = item.quality - 1
      }
      --decreaseLevel
    }
  }

  private fun increaseQualityBy(value: Int) {
    var increaseLevel = value
    while (increaseLevel > 0) {
      if (item.quality < 50) {
        item.quality = item.quality + 1
      }
      --increaseLevel
    }
  }
}