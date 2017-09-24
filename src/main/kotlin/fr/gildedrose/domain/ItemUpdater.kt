package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality(item: Item) {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }
    item.sellIn = item.sellIn - 1

    if (item.name.equals("Aged Brie")) {
      increaseQuality(item)

      if (item.sellIn < 0) {
        increaseQuality(item)
      }
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQuality(item)

      if (item.sellIn < 10) {
        increaseQuality(item)
      }

      if (item.sellIn < 5) {
        increaseQuality(item)
      }

      if (item.sellIn < 0) {
        item.quality = 0
      }
    } else {
      decreaseQuality(item)

      if (item.sellIn < 0) {
        decreaseQuality(item)
      }
    }
  }

  private fun decreaseQuality(item: Item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1
    }
  }

  private fun increaseQuality(item: Item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1
    }
  }
}