import com.expediagroup.graphql.plugin.gradle.config.GraphQLSerializer
import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLGenerateClientTask
import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLIntrospectSchemaTask

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("com.expediagroup.graphql")
    kotlin("plugin.serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // GraphQL
    val graphqlVersion: String by rootProject.extra
    implementation("com.expediagroup:graphql-kotlin-ktor-client:${graphqlVersion}")

    val ktorVersion: String by rootProject.extra
    implementation("io.ktor:ktor-client-okhttp:${ktorVersion}")
    implementation("io.ktor:ktor-client-logging-jvm:${ktorVersion}")
}

val graphqlIntrospectSchema
        by tasks.getting(GraphQLIntrospectSchemaTask::class) {
            endpoint.set("https://the-federation.info/v1/graphql")
        }

val graphqlGenerateClient
        by tasks.getting(GraphQLGenerateClientTask::class) {
            packageName.set("info.the-federation.graphql.generated")
            schemaFile.set(graphqlIntrospectSchema.outputFile)
            serializer.set(GraphQLSerializer.KOTLINX)

            dependsOn("graphqlIntrospectSchema")
        }
