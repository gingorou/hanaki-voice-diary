@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.chronos.ui.archive

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chronos.repository.DiaryRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DiaryArchiveScreen(
    repo: DiaryRepository,
    onBack: () -> Unit
) {
    val entries = repo.listEntries()
    val df = remember { SimpleDateFormat("MM/dd", Locale.JAPAN) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Diary archive") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("戻る") }
                }
            )
        }
    ) { pad ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(16.dp)
        ) {
            if (entries.isEmpty()) {
                Text("まだ日記がありません")
                return@Column
            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(entries) { e ->
                    val date = df.format(Date(e.epochMillis))
                    val head = e.text.take(20).replace("\n", " ")

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(date, modifier = Modifier.width(56.dp))
                            Spacer(Modifier.width(10.dp))

                            // 色（nullならグレー）
                            Box(
                                modifier = Modifier
                                    .size(14.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (e.moodColorArgb != null) Color(e.moodColorArgb)
                                        else Color(0xFFDDDDDD)
                                    )
                            )

                            Spacer(Modifier.width(10.dp))
                            Text(head, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
