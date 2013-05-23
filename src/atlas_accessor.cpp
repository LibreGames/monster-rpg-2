#include "monster2.hpp"
#include "atlas_internal.hpp"

int atlas_get_width(ATLAS *atlas)
{
	return atlas->width;
}

int atlas_get_height(ATLAS *atlas)
{
	return atlas->height;
}

int atlas_get_border(ATLAS *atlas)
{
	return atlas->border;
}

int atlas_get_destroy_bmps(ATLAS *atlas)
{
	return atlas->destroy_bmps;
}

int atlas_get_num_items(ATLAS *atlas)
{
	return atlas->num_items;
}

ATLAS_ITEM *atlas_get_item_by_id(ATLAS *atlas, int id)
{
	int i;

	for (i = 0; i < atlas->num_items; i++) {
		if (atlas->items[i]->id == id)
			return atlas->items[i];
	}

	return NULL;
}

ATLAS_ITEM *atlas_get_item_by_index(ATLAS *atlas, int index)
{
	assert(index >= 0 && index < atlas->num_items);
	return atlas->items[index];
}

int atlas_get_num_sheets(ATLAS *atlas)
{
	return atlas->num_sheets;
}

MBITMAP *atlas_get_sheet(ATLAS *atlas, int index)
{
	return atlas->sheets[index];
}

// --

MBITMAP *atlas_get_item_sub_bitmap(ATLAS_ITEM *item)
{
	return item->sub;
}

int atlas_get_item_sheet(ATLAS_ITEM *item)
{
	return item->sheet;
}

int atlas_get_item_x(ATLAS_ITEM *item)
{
	return item->x;
}

int atlas_get_item_y(ATLAS_ITEM *item)
{
	return item->y;
}

int atlas_get_item_id(ATLAS_ITEM *item)
{
	return item->id;
}

