package ir.homework.monuments_gallery

class Repository {
    val monumentList = mutableListOf<Monument>()

    fun setMonumentList(){
        monumentList.clear()
        monumentList.add(Monument(R.drawable.bagh_eram, "Eram Garden"))
        monumentList[0].description = R.string.monument1_description.toString()
        monumentList.add(Monument(R.drawable.darband, "Darband"))
        monumentList[1].description = R.string.monument2_description.toString()
        monumentList.add(Monument(R.drawable.ghale_roodkhan, "Ghale Roodkhan"))
        monumentList[2].description = R.string.monument3_description.toString()
        monumentList.add(Monument(R.drawable.masule, "Masouleh"))
        monumentList[3].description = R.string.monument4_description.toString()
        monumentList.add(Monument(R.drawable.meydan_naghsh_jahan, "Naghshe Jahan"))
        monumentList[4].description = R.string.monument5_description.toString()
        monumentList.add(Monument(R.drawable.pol_khaju, "Pole Khaju"))
        monumentList[5].description = R.string.monument6_description.toString()
    }
}