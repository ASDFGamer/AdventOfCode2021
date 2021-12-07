import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime


val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val srcDir: Path = Paths.get(projectDirAbsolutePath, "/src/main/kotlin/")
val resDir = Paths.get(projectDirAbsolutePath, "/src/main/resources/")

fun main(){
    val day: Int = LocalDateTime.now().dayOfMonth
    val template = """
    class Day$day: Day($day){
        override fun part1(input: List<String>, test:Boolean): String {
            TODO("Not yet implemented")
        }

        override fun part2(input: List<String>,  test:Boolean): String {
            TODO("Not yet implemented")
        }

    }
""".trimIndent()
    val className = "Day$day.kt"
    srcDir.resolve(className).toFile().writeText(template)

    val cookie = resDir.resolve(".cookie").toFile().readLines()[0]
    val uri = "https://adventofcode.com/2021/day/$day/input"
    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .header("Cookie", cookie)
        .build()
    val response = client.send(request, BodyHandlers.ofString())
    resDir.resolve("day$day.txt").toFile().writeText(response.body())
    resDir.resolve("day${day}_test.txt").toFile().writeText("")


}