package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }
    item.sellIn = item.sellIn - 1
    increaseQualityBy(1)

    if (item.name.equals("Aged Brie")) {
      if (item.sellIn < 0) {
        increaseQualityBy(1)
      }
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (item.sellIn < 10) {
        increaseQualityBy(1)
      }

      if (item.sellIn < 5) {
        increaseQualityBy(1)
      }

      if (item.sellIn < 0) {
        decreaseQuality(item.quality)
      }

    } else {
      decreaseQuality(1)
      decreaseQuality(1)

      if (item.sellIn < 0) {
        decreaseQuality(1)
      }
    }
  }

  private fun decreaseQuality(value: Int) {
    if (item.quality > 0) {
      item.quality = item.quality - value
    }
  }

  private fun increaseQualityBy(value: Int) {
    if (item.quality < 50) {
      item.quality = item.quality + value
    }
  }
}

enum class SellInCeil(val ceil: Int, val qualityModification: Int) {
}