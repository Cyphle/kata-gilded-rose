package fr.gildedrose.domain

class ItemUpdater(val item: Item) {
  fun updateQuality() {
    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }
    item.sellIn = item.sellIn - 1

    if (item.name.equals("Aged Brie")) {
      increaseQuality()

      if (item.sellIn < 0) {
        increaseQuality()
      }
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQuality()

      if (item.sellIn < 10) {
        increaseQuality()
      }

      if (item.sellIn < 5) {
        increaseQuality()
      }

      if (item.sellIn < 0) {
        item.quality = 0
      }
    } else {
      decreaseQuality()

      if (item.sellIn < 0) {
        decreaseQuality()
      }
    }
  }

  private fun decreaseQuality() {
    if (item.quality > 0) {
      item.quality = item.quality - 1
    }
  }

  private fun increaseQuality() {
    if (item.quality < 50) {
      item.quality = item.quality + 1
    }
  }
}