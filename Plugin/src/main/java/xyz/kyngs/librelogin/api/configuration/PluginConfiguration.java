package xyz.kyngs.librelogin.api.configuration;

import com.google.common.collect.Multimap;
import org.jetbrains.annotations.Nullable;
import xyz.kyngs.librelogin.api.LibreLoginPlugin;

import java.io.IOException;
import java.time.Duration;
import java.util.Collection;

/**
 * This interface manages the plugin configuration.
 *
 * @author kyngs
 */
public interface PluginConfiguration {

    /**
     * Reloads the configuration.
     *
     * @param plugin The plugin.
     * @return True if new configuration was generated, false otherwise.
     * @throws IOException                     If an I/O error occurs.
     * @throws CorruptedConfigurationException If the configuration is corrupted.
     */
    boolean reload(LibreLoginPlugin<?, ?> plugin) throws IOException, CorruptedConfigurationException;

    Collection<String> getAllowedCommandsWhileUnauthorized();

    String getDatabasePassword();

    String getDatabaseUser();

    String getDatabaseHost();

    String getDatabaseName();

    Multimap<String, String> getPassThrough();

    Collection<String> getLimbo();

    int getDatabasePort();

    String getDefaultCryptoProvider();

    boolean kickOnWrongPassword();

    boolean migrationOnNextStartup();

    String getMigrationType();

    String getMigrationOldDatabaseHost();

    int getMigrationOldDatabasePort();

    String getMigrationOldDatabaseUser();

    String getMigrationOldDatabasePassword();

    String getMigrationOldDatabaseName();

    String getMigrationOldDatabaseTable();

    NewUUIDCreator getNewUUIDCreator();

    boolean useTitles();

    boolean autoRegister();

    int milliSecondsToRefreshNotification();

    int secondsToAuthorize();

    boolean totpEnabled();

    String getTotpLabel();

    int minimumPasswordLength();

    /**
     * Gets the duration in which a session is valid.
     *
     * @return The duration, or null if sessions are not used.
     */
    @Nullable
    Duration getSessionTimeout();

    boolean pingServers();

    boolean rememberLastServer();

    int maxLifeTime();

    boolean debug();

    boolean fallback();
}