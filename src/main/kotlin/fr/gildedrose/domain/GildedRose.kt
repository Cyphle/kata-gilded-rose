package fr.gildedrose.domain

class GildedRose(var items: Array<Item>) {
  fun updateQuality() {
    items.indices.forEach { i ->
      updateQuality(i)
    }
  }

  private fun updateQuality(i: Int) {
    if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }
    items[i].sellIn = items[i].sellIn - 1

    if (items[i].name.equals("Aged Brie")) {
      increaseQuality(i)

      if (items[i].sellIn < 0) {
        increaseQuality(i)
      }
    } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQuality(i)

      if (items[i].sellIn < 10) {
        increaseQuality(i)
      }
      if (items[i].sellIn < 5) {
        increaseQuality(i)
      }

      if (items[i].sellIn < 0) {
        items[i].quality = items[i].quality - items[i].quality
      }
    } else {
      decreaseQuality(i)

      if (items[i].sellIn < 0) {
        decreaseQuality(i)
      }
    }
  }

  private fun decreaseQuality(i: Int) {
    if (items[i].quality > 0) {
      items[i].quality = items[i].quality - 1
    }
  }

  private fun increaseQuality(i: Int) {
    if (items[i].quality < 50) {
      items[i].quality = items[i].quality + 1
    }
  }
}