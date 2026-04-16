package com.example.noticias_practica3.data.repository

import com.example.noticias_practica3.data.NewsDto
import com.example.noticias_practica3.data.mapper.toBo
import com.example.noticias_practica3.data.model.NewsBo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object NewsRepository {
    suspend fun getNewsFromDataSource(): List<NewsDto> {
        return listOf(
            NewsDto(
                "1",
                "News for Android 16",
                "Fin the newest...",
                "The latest Android update brings helpful new features that add a spark of joy to your everyday routine. From sharing your live location mid-chat to discovering your next favorite app through bite-sized shorts, the latest Android features are designed to help you express yourself and stay in sync with what matters most. Here’s what’s new.\n" +
                        "\n" +
                        "1. Find your friends without leaving the chat.\n" +
                        "You can now share locations directly in Google Messages, thanks to Find Hub, so you can see each other on a real-time map view. Whether you’re meeting up at a concert or getting picked up at the airport, share your location for as long as you need, with the flexibility to stop sharing at any time – entirely within your conversation.\n" +
                        "\n" +
                        "Share real-time locations directly in Google Messages.\n" +
                        "\n" +
                        "2. Recover lost luggage by sharing your tracker tag link with the airline.\n" +
                        "Get missing bags back with help from Find Hub. If you’ve added a tracker tag to your luggage, share its location link with your participating airline so they can help find it and provide updates. It’s up to you when to share and when to stop sharing your luggage’s location. Travel with confidence knowing there’s another way to help your lost bags find their way back to you.",
                "12 Oct",
                "Alex",
                "Gadea",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/CPPGNCS225BTJLMR73XHZGIYFM.jpg"
            ),
            NewsDto(
                "2",
                "Compose Multiplatform",
                "Try it now...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "11 Oct",
                "Alex",
                "Vicente",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://i.ytimg.com/vi/JsugLEM6po0/maxresdefault.jpg"
            ),
            NewsDto(
                "3",
                "Kotlin 2.1",
                "Better call saul...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "10 Oct",
                "Alex",
                "Martinez",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeNt93GJrmzlQZ2aXF-HKODaM3Ufd-sdHHDQ&s"
            ),
            NewsDto(
                "4",
                "Material Design 4?",
                "Rumors...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "09 Oct",
                "Alex",
                "Prueba",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/102B7/production/_108613266_22d51f56-2a9f-4966-a0c4-d3c91687acfd.jpg.webp"
            ),
            NewsDto(
                "5",
                "Compose Multiplatform",
                "New look...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "11 Oct",
                "Alex",
                "Luke",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://ichef.bbci.co.uk/ace/ws/640/amz/worldservice/live/assets/images/2015/08/10/150810105302_android_624x351_getty.jpg.webp"
            ),
            NewsDto(
                "6",
                "Kotlin 2.1",
                "Update kotlin...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "10 Oct",
                "Alex",
                "Guimera",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://dplnews.com/wp-content/uploads/2021/07/dplnews_android12_vr140721.jpeg"
            ),
            NewsDto(
                "7",
                "Material Design 4?",
                "Material design rumors...",
                "Explore new apps with bite-sized videos in Google Play.\n" +
                        "Discovering apps is easier with Google Play shorts. Soon, you’ll be able to explore new content as you scroll through a feed of short-form videos, from wellness apps to photography, shopping and webtoons. It’s a simpler way to see how an app works and if it’s what you’re looking for, all without leaving Google Play.\n" +
                        "\n" +
                        "See apps in action before you tap download.\n" +
                        "\n" +
                        "4. Show up in style when you make a call with a custom Calling Card.\n" +
                        "Make conversations feel more personal by designing a custom Calling Card. Your friends will see your chosen photo, font and color, so your caller ID is as unique as you. Share it with everyone, or just your saved contacts, and edit or remove your Calling Card at any time.\n" +
                        "\n" +
                        "Design your own Calling Card for outgoing calls.\n" +
                        "\n" +
                        "5. Turn parked time into playtime with Teacher Approved kids games.\n" +
                        "Keep the family entertained while you’re parked with new Teacher Approved games and apps on Android Auto. The kid-friendly lineup, catered for ages 3 - 12, offers a fun and educational play experience right on your dashboard. Children can learn and play with like Disney Coloring World, LetraKid: Writing ABC for Kids, Marvel HQ: Kids Super Hero Fun, Draw a Stickman: EPIC 3, Kids Games: For Toddlers 3-5 and more.",
                "09 Oct",
                "Alex",
                "Villena",
                "https://developer.android.com/static/images/logos/android-developers-blog.svg?hl=es-419",
                "https://imagenes.20minutos.es/files/image_1920_1080/files/fp/uploads/imagenes/2022/05/05/android-malware.r_d.566-57.jpeg"
            )
        )
    }

    suspend fun getNews(): List<NewsBo> = withContext(Dispatchers.IO) {
        getNewsFromDataSource().map { it.toBo() }
    }
}