package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComIbmLibraryAccessors laccForComIbmLibraryAccessors = new ComIbmLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.ibm</b>
         */
        public ComIbmLibraryAccessors getIbm() {
            return laccForComIbmLibraryAccessors;
        }

    }

    public static class ComIbmLibraryAccessors extends SubDependencyFactory {
        private final ComIbmIcuLibraryAccessors laccForComIbmIcuLibraryAccessors = new ComIbmIcuLibraryAccessors(owner);

        public ComIbmLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.ibm.icu</b>
         */
        public ComIbmIcuLibraryAccessors getIcu() {
            return laccForComIbmIcuLibraryAccessors;
        }

    }

    public static class ComIbmIcuLibraryAccessors extends SubDependencyFactory {

        public ComIbmIcuLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>icu4j</b> with <b>com.ibm.icu:icu4j</b> coordinates and
         * with version reference <b>com.ibm.icu.icu4j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIcu4j() {
            return create("com.ibm.icu.icu4j");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoTakariLibraryAccessors laccForIoTakariLibraryAccessors = new IoTakariLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.takari</b>
         */
        public IoTakariLibraryAccessors getTakari() {
            return laccForIoTakariLibraryAccessors;
        }

    }

    public static class IoTakariLibraryAccessors extends SubDependencyFactory {
        private final IoTakariMavenLibraryAccessors laccForIoTakariMavenLibraryAccessors = new IoTakariMavenLibraryAccessors(owner);

        public IoTakariLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.takari.maven</b>
         */
        public IoTakariMavenLibraryAccessors getMaven() {
            return laccForIoTakariMavenLibraryAccessors;
        }

    }

    public static class IoTakariMavenLibraryAccessors extends SubDependencyFactory {
        private final IoTakariMavenPluginsLibraryAccessors laccForIoTakariMavenPluginsLibraryAccessors = new IoTakariMavenPluginsLibraryAccessors(owner);

        public IoTakariMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.takari.maven.plugins</b>
         */
        public IoTakariMavenPluginsLibraryAccessors getPlugins() {
            return laccForIoTakariMavenPluginsLibraryAccessors;
        }

    }

    public static class IoTakariMavenPluginsLibraryAccessors extends SubDependencyFactory {
        private final IoTakariMavenPluginsTakariLibraryAccessors laccForIoTakariMavenPluginsTakariLibraryAccessors = new IoTakariMavenPluginsTakariLibraryAccessors(owner);

        public IoTakariMavenPluginsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.takari.maven.plugins.takari</b>
         */
        public IoTakariMavenPluginsTakariLibraryAccessors getTakari() {
            return laccForIoTakariMavenPluginsTakariLibraryAccessors;
        }

    }

    public static class IoTakariMavenPluginsTakariLibraryAccessors extends SubDependencyFactory {
        private final IoTakariMavenPluginsTakariPluginLibraryAccessors laccForIoTakariMavenPluginsTakariPluginLibraryAccessors = new IoTakariMavenPluginsTakariPluginLibraryAccessors(owner);

        public IoTakariMavenPluginsTakariLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.takari.maven.plugins.takari.plugin</b>
         */
        public IoTakariMavenPluginsTakariPluginLibraryAccessors getPlugin() {
            return laccForIoTakariMavenPluginsTakariPluginLibraryAccessors;
        }

    }

    public static class IoTakariMavenPluginsTakariPluginLibraryAccessors extends SubDependencyFactory {

        public IoTakariMavenPluginsTakariPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testing</b> with <b>io.takari.maven.plugins:takari-plugin-testing</b> coordinates and
         * with version reference <b>io.takari.maven.plugins.takari.plugin.testing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("io.takari.maven.plugins.takari.plugin.testing");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgAbegoLibraryAccessors laccForOrgAbegoLibraryAccessors = new OrgAbegoLibraryAccessors(owner);
        private final OrgAntlrLibraryAccessors laccForOrgAntlrLibraryAccessors = new OrgAntlrLibraryAccessors(owner);
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgCodehausLibraryAccessors laccForOrgCodehausLibraryAccessors = new OrgCodehausLibraryAccessors(owner);
        private final OrgGlassfishLibraryAccessors laccForOrgGlassfishLibraryAccessors = new OrgGlassfishLibraryAccessors(owner);
        private final OrgJetbrainsLibraryAccessors laccForOrgJetbrainsLibraryAccessors = new OrgJetbrainsLibraryAccessors(owner);
        private final OrgJunitLibraryAccessors laccForOrgJunitLibraryAccessors = new OrgJunitLibraryAccessors(owner);
        private final OrgOpenjdkLibraryAccessors laccForOrgOpenjdkLibraryAccessors = new OrgOpenjdkLibraryAccessors(owner);
        private final OrgSlf4jLibraryAccessors laccForOrgSlf4jLibraryAccessors = new OrgSlf4jLibraryAccessors(owner);
        private final OrgSonatypeLibraryAccessors laccForOrgSonatypeLibraryAccessors = new OrgSonatypeLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.abego</b>
         */
        public OrgAbegoLibraryAccessors getAbego() {
            return laccForOrgAbegoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.antlr</b>
         */
        public OrgAntlrLibraryAccessors getAntlr() {
            return laccForOrgAntlrLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.codehaus</b>
         */
        public OrgCodehausLibraryAccessors getCodehaus() {
            return laccForOrgCodehausLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.glassfish</b>
         */
        public OrgGlassfishLibraryAccessors getGlassfish() {
            return laccForOrgGlassfishLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jetbrains</b>
         */
        public OrgJetbrainsLibraryAccessors getJetbrains() {
            return laccForOrgJetbrainsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.junit</b>
         */
        public OrgJunitLibraryAccessors getJunit() {
            return laccForOrgJunitLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.openjdk</b>
         */
        public OrgOpenjdkLibraryAccessors getOpenjdk() {
            return laccForOrgOpenjdkLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.slf4j</b>
         */
        public OrgSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.sonatype</b>
         */
        public OrgSonatypeLibraryAccessors getSonatype() {
            return laccForOrgSonatypeLibraryAccessors;
        }

    }

    public static class OrgAbegoLibraryAccessors extends SubDependencyFactory {
        private final OrgAbegoTreelayoutLibraryAccessors laccForOrgAbegoTreelayoutLibraryAccessors = new OrgAbegoTreelayoutLibraryAccessors(owner);

        public OrgAbegoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.abego.treelayout</b>
         */
        public OrgAbegoTreelayoutLibraryAccessors getTreelayout() {
            return laccForOrgAbegoTreelayoutLibraryAccessors;
        }

    }

    public static class OrgAbegoTreelayoutLibraryAccessors extends SubDependencyFactory {
        private final OrgAbegoTreelayoutOrgLibraryAccessors laccForOrgAbegoTreelayoutOrgLibraryAccessors = new OrgAbegoTreelayoutOrgLibraryAccessors(owner);

        public OrgAbegoTreelayoutLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.abego.treelayout.org</b>
         */
        public OrgAbegoTreelayoutOrgLibraryAccessors getOrg() {
            return laccForOrgAbegoTreelayoutOrgLibraryAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgLibraryAccessors extends SubDependencyFactory {
        private final OrgAbegoTreelayoutOrgAbegoLibraryAccessors laccForOrgAbegoTreelayoutOrgAbegoLibraryAccessors = new OrgAbegoTreelayoutOrgAbegoLibraryAccessors(owner);

        public OrgAbegoTreelayoutOrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.abego.treelayout.org.abego</b>
         */
        public OrgAbegoTreelayoutOrgAbegoLibraryAccessors getAbego() {
            return laccForOrgAbegoTreelayoutOrgAbegoLibraryAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgAbegoLibraryAccessors extends SubDependencyFactory {
        private final OrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors laccForOrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors = new OrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors(owner);

        public OrgAbegoTreelayoutOrgAbegoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.abego.treelayout.org.abego.treelayout</b>
         */
        public OrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors getTreelayout() {
            return laccForOrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors extends SubDependencyFactory {

        public OrgAbegoTreelayoutOrgAbegoTreelayoutLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.abego.treelayout:org.abego.treelayout.core</b> coordinates and
         * with version reference <b>org.abego.treelayout.org.abego.treelayout.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.abego.treelayout.org.abego.treelayout.core");
        }

    }

    public static class OrgAntlrLibraryAccessors extends SubDependencyFactory {
        private final OrgAntlrAntlrLibraryAccessors laccForOrgAntlrAntlrLibraryAccessors = new OrgAntlrAntlrLibraryAccessors(owner);

        public OrgAntlrLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>st4</b> with <b>org.antlr:ST4</b> coordinates and
         * with version reference <b>org.antlr.st4</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSt4() {
            return create("org.antlr.st4");
        }

        /**
         * Group of libraries at <b>org.antlr.antlr</b>
         */
        public OrgAntlrAntlrLibraryAccessors getAntlr() {
            return laccForOrgAntlrAntlrLibraryAccessors;
        }

    }

    public static class OrgAntlrAntlrLibraryAccessors extends SubDependencyFactory {

        public OrgAntlrAntlrLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>runtime</b> with <b>org.antlr:antlr-runtime</b> coordinates and
         * with version reference <b>org.antlr.antlr.runtime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("org.antlr.antlr.runtime");
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenLibraryAccessors laccForOrgApacheMavenLibraryAccessors = new OrgApacheMavenLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven</b>
         */
        public OrgApacheMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenLibraryAccessors;
        }

    }

    public static class OrgApacheMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenMavenLibraryAccessors laccForOrgApacheMavenMavenLibraryAccessors = new OrgApacheMavenMavenLibraryAccessors(owner);
        private final OrgApacheMavenPluginLibraryAccessors laccForOrgApacheMavenPluginLibraryAccessors = new OrgApacheMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.maven</b>
         */
        public OrgApacheMavenMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenMavenLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.maven.plugin</b>
         */
        public OrgApacheMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenMavenPluginLibraryAccessors laccForOrgApacheMavenMavenPluginLibraryAccessors = new OrgApacheMavenMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compat</b> with <b>org.apache.maven:maven-compat</b> coordinates and
         * with version reference <b>org.apache.maven.maven.compat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompat() {
            return create("org.apache.maven.maven.compat");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.maven:maven-core</b> coordinates and
         * with version reference <b>org.apache.maven.maven.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.apache.maven.maven.core");
        }

        /**
         * Group of libraries at <b>org.apache.maven.maven.plugin</b>
         */
        public OrgApacheMavenMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenMavenPluginLibraryAccessors extends SubDependencyFactory {

        public OrgApacheMavenMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.apache.maven:maven-plugin-api</b> coordinates and
         * with version reference <b>org.apache.maven.maven.plugin.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.apache.maven.maven.plugin.api");
        }

    }

    public static class OrgApacheMavenPluginLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsLibraryAccessors laccForOrgApacheMavenPluginToolsLibraryAccessors = new OrgApacheMavenPluginToolsLibraryAccessors(owner);

        public OrgApacheMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools</b>
         */
        public OrgApacheMavenPluginToolsLibraryAccessors getTools() {
            return laccForOrgApacheMavenPluginToolsLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsMavenLibraryAccessors laccForOrgApacheMavenPluginToolsMavenLibraryAccessors = new OrgApacheMavenPluginToolsMavenLibraryAccessors(owner);

        public OrgApacheMavenPluginToolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools.maven</b>
         */
        public OrgApacheMavenPluginToolsMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenPluginToolsMavenLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsMavenPluginLibraryAccessors laccForOrgApacheMavenPluginToolsMavenPluginLibraryAccessors = new OrgApacheMavenPluginToolsMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenPluginToolsMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools.maven.plugin</b>
         */
        public OrgApacheMavenPluginToolsMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenPluginToolsMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenPluginLibraryAccessors extends SubDependencyFactory {

        public OrgApacheMavenPluginToolsMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>org.apache.maven.plugin-tools:maven-plugin-annotations</b> coordinates and
         * with version reference <b>org.apache.maven.plugin.tools.maven.plugin.annotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("org.apache.maven.plugin.tools.maven.plugin.annotations");
        }

    }

    public static class OrgCodehausLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausPlexusLibraryAccessors laccForOrgCodehausPlexusLibraryAccessors = new OrgCodehausPlexusLibraryAccessors(owner);

        public OrgCodehausLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.codehaus.plexus</b>
         */
        public OrgCodehausPlexusLibraryAccessors getPlexus() {
            return laccForOrgCodehausPlexusLibraryAccessors;
        }

    }

    public static class OrgCodehausPlexusLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausPlexusPlexusLibraryAccessors laccForOrgCodehausPlexusPlexusLibraryAccessors = new OrgCodehausPlexusPlexusLibraryAccessors(owner);

        public OrgCodehausPlexusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.codehaus.plexus.plexus</b>
         */
        public OrgCodehausPlexusPlexusLibraryAccessors getPlexus() {
            return laccForOrgCodehausPlexusPlexusLibraryAccessors;
        }

    }

    public static class OrgCodehausPlexusPlexusLibraryAccessors extends SubDependencyFactory {
        private final OrgCodehausPlexusPlexusCompilerLibraryAccessors laccForOrgCodehausPlexusPlexusCompilerLibraryAccessors = new OrgCodehausPlexusPlexusCompilerLibraryAccessors(owner);

        public OrgCodehausPlexusPlexusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>utils</b> with <b>org.codehaus.plexus:plexus-utils</b> coordinates and
         * with version reference <b>org.codehaus.plexus.plexus.utils</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUtils() {
            return create("org.codehaus.plexus.plexus.utils");
        }

        /**
         * Group of libraries at <b>org.codehaus.plexus.plexus.compiler</b>
         */
        public OrgCodehausPlexusPlexusCompilerLibraryAccessors getCompiler() {
            return laccForOrgCodehausPlexusPlexusCompilerLibraryAccessors;
        }

    }

    public static class OrgCodehausPlexusPlexusCompilerLibraryAccessors extends SubDependencyFactory {

        public OrgCodehausPlexusPlexusCompilerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.codehaus.plexus:plexus-compiler-api</b> coordinates and
         * with version reference <b>org.codehaus.plexus.plexus.compiler.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.codehaus.plexus.plexus.compiler.api");
        }

    }

    public static class OrgGlassfishLibraryAccessors extends SubDependencyFactory {
        private final OrgGlassfishJavaxLibraryAccessors laccForOrgGlassfishJavaxLibraryAccessors = new OrgGlassfishJavaxLibraryAccessors(owner);

        public OrgGlassfishLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.glassfish.javax</b>
         */
        public OrgGlassfishJavaxLibraryAccessors getJavax() {
            return laccForOrgGlassfishJavaxLibraryAccessors;
        }

    }

    public static class OrgGlassfishJavaxLibraryAccessors extends SubDependencyFactory {

        public OrgGlassfishJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>org.glassfish:javax.json</b> coordinates and
         * with version reference <b>org.glassfish.javax.json</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("org.glassfish.javax.json");
        }

    }

    public static class OrgJetbrainsLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinLibraryAccessors laccForOrgJetbrainsKotlinLibraryAccessors = new OrgJetbrainsKotlinLibraryAccessors(owner);

        public OrgJetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin</b>
         */
        public OrgJetbrainsKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinKotlinLibraryAccessors laccForOrgJetbrainsKotlinKotlinLibraryAccessors = new OrgJetbrainsKotlinKotlinLibraryAccessors(owner);

        public OrgJetbrainsKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin.kotlin</b>
         */
        public OrgJetbrainsKotlinKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinKotlinLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>org.jetbrains.kotlin:kotlin-compiler</b> coordinates and
         * with version reference <b>org.jetbrains.kotlin.kotlin.compiler</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("org.jetbrains.kotlin.kotlin.compiler");
        }

        /**
         * Dependency provider for <b>stdlib</b> with <b>org.jetbrains.kotlin:kotlin-stdlib</b> coordinates and
         * with version reference <b>org.jetbrains.kotlin.kotlin.stdlib</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getStdlib() {
            return create("org.jetbrains.kotlin.kotlin.stdlib");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.jetbrains.kotlin:kotlin-test</b> coordinates and
         * with version reference <b>org.jetbrains.kotlin.kotlin.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.jetbrains.kotlin.kotlin.test");
        }

    }

    public static class OrgJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterLibraryAccessors laccForOrgJunitJupiterLibraryAccessors = new OrgJunitJupiterLibraryAccessors(owner);

        public OrgJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.jupiter</b>
         */
        public OrgJunitJupiterLibraryAccessors getJupiter() {
            return laccForOrgJunitJupiterLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitLibraryAccessors laccForOrgJunitJupiterJunitLibraryAccessors = new OrgJunitJupiterJunitLibraryAccessors(owner);

        public OrgJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.jupiter.junit</b>
         */
        public OrgJunitJupiterJunitLibraryAccessors getJunit() {
            return laccForOrgJunitJupiterJunitLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitJupiterJunitJupiterLibraryAccessors laccForOrgJunitJupiterJunitJupiterLibraryAccessors = new OrgJunitJupiterJunitJupiterLibraryAccessors(owner);

        public OrgJunitJupiterJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.jupiter.junit.jupiter</b>
         */
        public OrgJunitJupiterJunitJupiterLibraryAccessors getJupiter() {
            return laccForOrgJunitJupiterJunitJupiterLibraryAccessors;
        }

    }

    public static class OrgJunitJupiterJunitJupiterLibraryAccessors extends SubDependencyFactory {

        public OrgJunitJupiterJunitJupiterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.junit.jupiter:junit-jupiter-api</b> coordinates and
         * with version reference <b>org.junit.jupiter.junit.jupiter.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.junit.jupiter.junit.jupiter.api");
        }

        /**
         * Dependency provider for <b>engine</b> with <b>org.junit.jupiter:junit-jupiter-engine</b> coordinates and
         * with version reference <b>org.junit.jupiter.junit.jupiter.engine</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEngine() {
            return create("org.junit.jupiter.junit.jupiter.engine");
        }

        /**
         * Dependency provider for <b>params</b> with <b>org.junit.jupiter:junit-jupiter-params</b> coordinates and
         * with version reference <b>org.junit.jupiter.junit.jupiter.params</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getParams() {
            return create("org.junit.jupiter.junit.jupiter.params");
        }

    }

    public static class OrgOpenjdkLibraryAccessors extends SubDependencyFactory {
        private final OrgOpenjdkJolLibraryAccessors laccForOrgOpenjdkJolLibraryAccessors = new OrgOpenjdkJolLibraryAccessors(owner);

        public OrgOpenjdkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.openjdk.jol</b>
         */
        public OrgOpenjdkJolLibraryAccessors getJol() {
            return laccForOrgOpenjdkJolLibraryAccessors;
        }

    }

    public static class OrgOpenjdkJolLibraryAccessors extends SubDependencyFactory {
        private final OrgOpenjdkJolJolLibraryAccessors laccForOrgOpenjdkJolJolLibraryAccessors = new OrgOpenjdkJolJolLibraryAccessors(owner);

        public OrgOpenjdkJolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.openjdk.jol.jol</b>
         */
        public OrgOpenjdkJolJolLibraryAccessors getJol() {
            return laccForOrgOpenjdkJolJolLibraryAccessors;
        }

    }

    public static class OrgOpenjdkJolJolLibraryAccessors extends SubDependencyFactory {

        public OrgOpenjdkJolJolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.openjdk.jol:jol-core</b> coordinates and
         * with version reference <b>org.openjdk.jol.jol.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.openjdk.jol.jol.core");
        }

    }

    public static class OrgSlf4jLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jSlf4jLibraryAccessors laccForOrgSlf4jSlf4jLibraryAccessors = new OrgSlf4jSlf4jLibraryAccessors(owner);

        public OrgSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jSlf4jLibraryAccessors;
        }

    }

    public static class OrgSlf4jSlf4jLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.slf4j:slf4j-api</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.slf4j.slf4j.api");
        }

        /**
         * Dependency provider for <b>simple</b> with <b>org.slf4j:slf4j-simple</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.simple</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSimple() {
            return create("org.slf4j.slf4j.simple");
        }

    }

    public static class OrgSonatypeLibraryAccessors extends SubDependencyFactory {
        private final OrgSonatypePlexusLibraryAccessors laccForOrgSonatypePlexusLibraryAccessors = new OrgSonatypePlexusLibraryAccessors(owner);

        public OrgSonatypeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonatype.plexus</b>
         */
        public OrgSonatypePlexusLibraryAccessors getPlexus() {
            return laccForOrgSonatypePlexusLibraryAccessors;
        }

    }

    public static class OrgSonatypePlexusLibraryAccessors extends SubDependencyFactory {
        private final OrgSonatypePlexusPlexusLibraryAccessors laccForOrgSonatypePlexusPlexusLibraryAccessors = new OrgSonatypePlexusPlexusLibraryAccessors(owner);

        public OrgSonatypePlexusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonatype.plexus.plexus</b>
         */
        public OrgSonatypePlexusPlexusLibraryAccessors getPlexus() {
            return laccForOrgSonatypePlexusPlexusLibraryAccessors;
        }

    }

    public static class OrgSonatypePlexusPlexusLibraryAccessors extends SubDependencyFactory {
        private final OrgSonatypePlexusPlexusBuildLibraryAccessors laccForOrgSonatypePlexusPlexusBuildLibraryAccessors = new OrgSonatypePlexusPlexusBuildLibraryAccessors(owner);

        public OrgSonatypePlexusPlexusLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonatype.plexus.plexus.build</b>
         */
        public OrgSonatypePlexusPlexusBuildLibraryAccessors getBuild() {
            return laccForOrgSonatypePlexusPlexusBuildLibraryAccessors;
        }

    }

    public static class OrgSonatypePlexusPlexusBuildLibraryAccessors extends SubDependencyFactory {

        public OrgSonatypePlexusPlexusBuildLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.sonatype.plexus:plexus-build-api</b> coordinates and
         * with version reference <b>org.sonatype.plexus.plexus.build.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.sonatype.plexus.plexus.build.api");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io</b>
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComIbmVersionAccessors vaccForComIbmVersionAccessors = new ComIbmVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.ibm</b>
         */
        public ComIbmVersionAccessors getIbm() {
            return vaccForComIbmVersionAccessors;
        }

    }

    public static class ComIbmVersionAccessors extends VersionFactory  {

        private final ComIbmIcuVersionAccessors vaccForComIbmIcuVersionAccessors = new ComIbmIcuVersionAccessors(providers, config);
        public ComIbmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.ibm.icu</b>
         */
        public ComIbmIcuVersionAccessors getIcu() {
            return vaccForComIbmIcuVersionAccessors;
        }

    }

    public static class ComIbmIcuVersionAccessors extends VersionFactory  {

        public ComIbmIcuVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.ibm.icu.icu4j</b> with value <b>72.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getIcu4j() { return getVersion("com.ibm.icu.icu4j"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoTakariVersionAccessors vaccForIoTakariVersionAccessors = new IoTakariVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.takari</b>
         */
        public IoTakariVersionAccessors getTakari() {
            return vaccForIoTakariVersionAccessors;
        }

    }

    public static class IoTakariVersionAccessors extends VersionFactory  {

        private final IoTakariMavenVersionAccessors vaccForIoTakariMavenVersionAccessors = new IoTakariMavenVersionAccessors(providers, config);
        public IoTakariVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.takari.maven</b>
         */
        public IoTakariMavenVersionAccessors getMaven() {
            return vaccForIoTakariMavenVersionAccessors;
        }

    }

    public static class IoTakariMavenVersionAccessors extends VersionFactory  {

        private final IoTakariMavenPluginsVersionAccessors vaccForIoTakariMavenPluginsVersionAccessors = new IoTakariMavenPluginsVersionAccessors(providers, config);
        public IoTakariMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.takari.maven.plugins</b>
         */
        public IoTakariMavenPluginsVersionAccessors getPlugins() {
            return vaccForIoTakariMavenPluginsVersionAccessors;
        }

    }

    public static class IoTakariMavenPluginsVersionAccessors extends VersionFactory  {

        private final IoTakariMavenPluginsTakariVersionAccessors vaccForIoTakariMavenPluginsTakariVersionAccessors = new IoTakariMavenPluginsTakariVersionAccessors(providers, config);
        public IoTakariMavenPluginsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.takari.maven.plugins.takari</b>
         */
        public IoTakariMavenPluginsTakariVersionAccessors getTakari() {
            return vaccForIoTakariMavenPluginsTakariVersionAccessors;
        }

    }

    public static class IoTakariMavenPluginsTakariVersionAccessors extends VersionFactory  {

        private final IoTakariMavenPluginsTakariPluginVersionAccessors vaccForIoTakariMavenPluginsTakariPluginVersionAccessors = new IoTakariMavenPluginsTakariPluginVersionAccessors(providers, config);
        public IoTakariMavenPluginsTakariVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.takari.maven.plugins.takari.plugin</b>
         */
        public IoTakariMavenPluginsTakariPluginVersionAccessors getPlugin() {
            return vaccForIoTakariMavenPluginsTakariPluginVersionAccessors;
        }

    }

    public static class IoTakariMavenPluginsTakariPluginVersionAccessors extends VersionFactory  {

        public IoTakariMavenPluginsTakariPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.takari.maven.plugins.takari.plugin.testing</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTesting() { return getVersion("io.takari.maven.plugins.takari.plugin.testing"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgAbegoVersionAccessors vaccForOrgAbegoVersionAccessors = new OrgAbegoVersionAccessors(providers, config);
        private final OrgAntlrVersionAccessors vaccForOrgAntlrVersionAccessors = new OrgAntlrVersionAccessors(providers, config);
        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgCodehausVersionAccessors vaccForOrgCodehausVersionAccessors = new OrgCodehausVersionAccessors(providers, config);
        private final OrgGlassfishVersionAccessors vaccForOrgGlassfishVersionAccessors = new OrgGlassfishVersionAccessors(providers, config);
        private final OrgJetbrainsVersionAccessors vaccForOrgJetbrainsVersionAccessors = new OrgJetbrainsVersionAccessors(providers, config);
        private final OrgJunitVersionAccessors vaccForOrgJunitVersionAccessors = new OrgJunitVersionAccessors(providers, config);
        private final OrgOpenjdkVersionAccessors vaccForOrgOpenjdkVersionAccessors = new OrgOpenjdkVersionAccessors(providers, config);
        private final OrgSlf4jVersionAccessors vaccForOrgSlf4jVersionAccessors = new OrgSlf4jVersionAccessors(providers, config);
        private final OrgSonatypeVersionAccessors vaccForOrgSonatypeVersionAccessors = new OrgSonatypeVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.abego</b>
         */
        public OrgAbegoVersionAccessors getAbego() {
            return vaccForOrgAbegoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.antlr</b>
         */
        public OrgAntlrVersionAccessors getAntlr() {
            return vaccForOrgAntlrVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.codehaus</b>
         */
        public OrgCodehausVersionAccessors getCodehaus() {
            return vaccForOrgCodehausVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.glassfish</b>
         */
        public OrgGlassfishVersionAccessors getGlassfish() {
            return vaccForOrgGlassfishVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.jetbrains</b>
         */
        public OrgJetbrainsVersionAccessors getJetbrains() {
            return vaccForOrgJetbrainsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.junit</b>
         */
        public OrgJunitVersionAccessors getJunit() {
            return vaccForOrgJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.openjdk</b>
         */
        public OrgOpenjdkVersionAccessors getOpenjdk() {
            return vaccForOrgOpenjdkVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.slf4j</b>
         */
        public OrgSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.sonatype</b>
         */
        public OrgSonatypeVersionAccessors getSonatype() {
            return vaccForOrgSonatypeVersionAccessors;
        }

    }

    public static class OrgAbegoVersionAccessors extends VersionFactory  {

        private final OrgAbegoTreelayoutVersionAccessors vaccForOrgAbegoTreelayoutVersionAccessors = new OrgAbegoTreelayoutVersionAccessors(providers, config);
        public OrgAbegoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.abego.treelayout</b>
         */
        public OrgAbegoTreelayoutVersionAccessors getTreelayout() {
            return vaccForOrgAbegoTreelayoutVersionAccessors;
        }

    }

    public static class OrgAbegoTreelayoutVersionAccessors extends VersionFactory  {

        private final OrgAbegoTreelayoutOrgVersionAccessors vaccForOrgAbegoTreelayoutOrgVersionAccessors = new OrgAbegoTreelayoutOrgVersionAccessors(providers, config);
        public OrgAbegoTreelayoutVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.abego.treelayout.org</b>
         */
        public OrgAbegoTreelayoutOrgVersionAccessors getOrg() {
            return vaccForOrgAbegoTreelayoutOrgVersionAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgVersionAccessors extends VersionFactory  {

        private final OrgAbegoTreelayoutOrgAbegoVersionAccessors vaccForOrgAbegoTreelayoutOrgAbegoVersionAccessors = new OrgAbegoTreelayoutOrgAbegoVersionAccessors(providers, config);
        public OrgAbegoTreelayoutOrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.abego.treelayout.org.abego</b>
         */
        public OrgAbegoTreelayoutOrgAbegoVersionAccessors getAbego() {
            return vaccForOrgAbegoTreelayoutOrgAbegoVersionAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgAbegoVersionAccessors extends VersionFactory  {

        private final OrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors vaccForOrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors = new OrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors(providers, config);
        public OrgAbegoTreelayoutOrgAbegoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.abego.treelayout.org.abego.treelayout</b>
         */
        public OrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors getTreelayout() {
            return vaccForOrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors;
        }

    }

    public static class OrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors extends VersionFactory  {

        public OrgAbegoTreelayoutOrgAbegoTreelayoutVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.abego.treelayout.org.abego.treelayout.core</b> with value <b>1.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.abego.treelayout.org.abego.treelayout.core"); }

    }

    public static class OrgAntlrVersionAccessors extends VersionFactory  {

        private final OrgAntlrAntlrVersionAccessors vaccForOrgAntlrAntlrVersionAccessors = new OrgAntlrAntlrVersionAccessors(providers, config);
        public OrgAntlrVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.antlr.st4</b> with value <b>4.3.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSt4() { return getVersion("org.antlr.st4"); }

        /**
         * Group of versions at <b>versions.org.antlr.antlr</b>
         */
        public OrgAntlrAntlrVersionAccessors getAntlr() {
            return vaccForOrgAntlrAntlrVersionAccessors;
        }

    }

    public static class OrgAntlrAntlrVersionAccessors extends VersionFactory  {

        public OrgAntlrAntlrVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.antlr.antlr.runtime</b> with value <b>3.5.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRuntime() { return getVersion("org.antlr.antlr.runtime"); }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenVersionAccessors vaccForOrgApacheMavenVersionAccessors = new OrgApacheMavenVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven</b>
         */
        public OrgApacheMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenVersionAccessors;
        }

    }

    public static class OrgApacheMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenMavenVersionAccessors vaccForOrgApacheMavenMavenVersionAccessors = new OrgApacheMavenMavenVersionAccessors(providers, config);
        private final OrgApacheMavenPluginVersionAccessors vaccForOrgApacheMavenPluginVersionAccessors = new OrgApacheMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.maven</b>
         */
        public OrgApacheMavenMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenMavenVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin</b>
         */
        public OrgApacheMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenMavenPluginVersionAccessors vaccForOrgApacheMavenMavenPluginVersionAccessors = new OrgApacheMavenMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.maven.compat</b> with value <b>3.8.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompat() { return getVersion("org.apache.maven.maven.compat"); }

        /**
         * Version alias <b>org.apache.maven.maven.core</b> with value <b>3.8.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.apache.maven.maven.core"); }

        /**
         * Group of versions at <b>versions.org.apache.maven.maven.plugin</b>
         */
        public OrgApacheMavenMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenMavenPluginVersionAccessors extends VersionFactory  {

        public OrgApacheMavenMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.maven.plugin.api</b> with value <b>3.8.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.apache.maven.maven.plugin.api"); }

    }

    public static class OrgApacheMavenPluginVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsVersionAccessors vaccForOrgApacheMavenPluginToolsVersionAccessors = new OrgApacheMavenPluginToolsVersionAccessors(providers, config);
        public OrgApacheMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools</b>
         */
        public OrgApacheMavenPluginToolsVersionAccessors getTools() {
            return vaccForOrgApacheMavenPluginToolsVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsMavenVersionAccessors vaccForOrgApacheMavenPluginToolsMavenVersionAccessors = new OrgApacheMavenPluginToolsMavenVersionAccessors(providers, config);
        public OrgApacheMavenPluginToolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools.maven</b>
         */
        public OrgApacheMavenPluginToolsMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenPluginToolsMavenVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsMavenPluginVersionAccessors vaccForOrgApacheMavenPluginToolsMavenPluginVersionAccessors = new OrgApacheMavenPluginToolsMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenPluginToolsMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools.maven.plugin</b>
         */
        public OrgApacheMavenPluginToolsMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenPluginToolsMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenPluginVersionAccessors extends VersionFactory  {

        public OrgApacheMavenPluginToolsMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.plugin.tools.maven.plugin.annotations</b> with value <b>3.6.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotations() { return getVersion("org.apache.maven.plugin.tools.maven.plugin.annotations"); }

    }

    public static class OrgCodehausVersionAccessors extends VersionFactory  {

        private final OrgCodehausPlexusVersionAccessors vaccForOrgCodehausPlexusVersionAccessors = new OrgCodehausPlexusVersionAccessors(providers, config);
        public OrgCodehausVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.codehaus.plexus</b>
         */
        public OrgCodehausPlexusVersionAccessors getPlexus() {
            return vaccForOrgCodehausPlexusVersionAccessors;
        }

    }

    public static class OrgCodehausPlexusVersionAccessors extends VersionFactory  {

        private final OrgCodehausPlexusPlexusVersionAccessors vaccForOrgCodehausPlexusPlexusVersionAccessors = new OrgCodehausPlexusPlexusVersionAccessors(providers, config);
        public OrgCodehausPlexusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.codehaus.plexus.plexus</b>
         */
        public OrgCodehausPlexusPlexusVersionAccessors getPlexus() {
            return vaccForOrgCodehausPlexusPlexusVersionAccessors;
        }

    }

    public static class OrgCodehausPlexusPlexusVersionAccessors extends VersionFactory  {

        private final OrgCodehausPlexusPlexusCompilerVersionAccessors vaccForOrgCodehausPlexusPlexusCompilerVersionAccessors = new OrgCodehausPlexusPlexusCompilerVersionAccessors(providers, config);
        public OrgCodehausPlexusPlexusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.codehaus.plexus.plexus.utils</b> with value <b>3.4.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUtils() { return getVersion("org.codehaus.plexus.plexus.utils"); }

        /**
         * Group of versions at <b>versions.org.codehaus.plexus.plexus.compiler</b>
         */
        public OrgCodehausPlexusPlexusCompilerVersionAccessors getCompiler() {
            return vaccForOrgCodehausPlexusPlexusCompilerVersionAccessors;
        }

    }

    public static class OrgCodehausPlexusPlexusCompilerVersionAccessors extends VersionFactory  {

        public OrgCodehausPlexusPlexusCompilerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.codehaus.plexus.plexus.compiler.api</b> with value <b>2.12.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.codehaus.plexus.plexus.compiler.api"); }

    }

    public static class OrgGlassfishVersionAccessors extends VersionFactory  {

        private final OrgGlassfishJavaxVersionAccessors vaccForOrgGlassfishJavaxVersionAccessors = new OrgGlassfishJavaxVersionAccessors(providers, config);
        public OrgGlassfishVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.glassfish.javax</b>
         */
        public OrgGlassfishJavaxVersionAccessors getJavax() {
            return vaccForOrgGlassfishJavaxVersionAccessors;
        }

    }

    public static class OrgGlassfishJavaxVersionAccessors extends VersionFactory  {

        public OrgGlassfishJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.glassfish.javax.json</b> with value <b>1.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJson() { return getVersion("org.glassfish.javax.json"); }

    }

    public static class OrgJetbrainsVersionAccessors extends VersionFactory  {

        private final OrgJetbrainsKotlinVersionAccessors vaccForOrgJetbrainsKotlinVersionAccessors = new OrgJetbrainsKotlinVersionAccessors(providers, config);
        public OrgJetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.jetbrains.kotlin</b>
         */
        public OrgJetbrainsKotlinVersionAccessors getKotlin() {
            return vaccForOrgJetbrainsKotlinVersionAccessors;
        }

    }

    public static class OrgJetbrainsKotlinVersionAccessors extends VersionFactory  {

        private final OrgJetbrainsKotlinKotlinVersionAccessors vaccForOrgJetbrainsKotlinKotlinVersionAccessors = new OrgJetbrainsKotlinKotlinVersionAccessors(providers, config);
        public OrgJetbrainsKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.jetbrains.kotlin.kotlin</b>
         */
        public OrgJetbrainsKotlinKotlinVersionAccessors getKotlin() {
            return vaccForOrgJetbrainsKotlinKotlinVersionAccessors;
        }

    }

    public static class OrgJetbrainsKotlinKotlinVersionAccessors extends VersionFactory  {

        public OrgJetbrainsKotlinKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.jetbrains.kotlin.kotlin.compiler</b> with value <b>2.0.0-Beta4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompiler() { return getVersion("org.jetbrains.kotlin.kotlin.compiler"); }

        /**
         * Version alias <b>org.jetbrains.kotlin.kotlin.stdlib</b> with value <b>2.0.0-Beta4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getStdlib() { return getVersion("org.jetbrains.kotlin.kotlin.stdlib"); }

        /**
         * Version alias <b>org.jetbrains.kotlin.kotlin.test</b> with value <b>2.0.0-Beta4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.jetbrains.kotlin.kotlin.test"); }

    }

    public static class OrgJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterVersionAccessors vaccForOrgJunitJupiterVersionAccessors = new OrgJunitJupiterVersionAccessors(providers, config);
        public OrgJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.jupiter</b>
         */
        public OrgJunitJupiterVersionAccessors getJupiter() {
            return vaccForOrgJunitJupiterVersionAccessors;
        }

    }

    public static class OrgJunitJupiterVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterJunitVersionAccessors vaccForOrgJunitJupiterJunitVersionAccessors = new OrgJunitJupiterJunitVersionAccessors(providers, config);
        public OrgJunitJupiterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.jupiter.junit</b>
         */
        public OrgJunitJupiterJunitVersionAccessors getJunit() {
            return vaccForOrgJunitJupiterJunitVersionAccessors;
        }

    }

    public static class OrgJunitJupiterJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitJupiterJunitJupiterVersionAccessors vaccForOrgJunitJupiterJunitJupiterVersionAccessors = new OrgJunitJupiterJunitJupiterVersionAccessors(providers, config);
        public OrgJunitJupiterJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.jupiter.junit.jupiter</b>
         */
        public OrgJunitJupiterJunitJupiterVersionAccessors getJupiter() {
            return vaccForOrgJunitJupiterJunitJupiterVersionAccessors;
        }

    }

    public static class OrgJunitJupiterJunitJupiterVersionAccessors extends VersionFactory  {

        public OrgJunitJupiterJunitJupiterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.junit.jupiter.junit.jupiter.api</b> with value <b>5.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.junit.jupiter.junit.jupiter.api"); }

        /**
         * Version alias <b>org.junit.jupiter.junit.jupiter.engine</b> with value <b>5.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEngine() { return getVersion("org.junit.jupiter.junit.jupiter.engine"); }

        /**
         * Version alias <b>org.junit.jupiter.junit.jupiter.params</b> with value <b>5.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getParams() { return getVersion("org.junit.jupiter.junit.jupiter.params"); }

    }

    public static class OrgOpenjdkVersionAccessors extends VersionFactory  {

        private final OrgOpenjdkJolVersionAccessors vaccForOrgOpenjdkJolVersionAccessors = new OrgOpenjdkJolVersionAccessors(providers, config);
        public OrgOpenjdkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.openjdk.jol</b>
         */
        public OrgOpenjdkJolVersionAccessors getJol() {
            return vaccForOrgOpenjdkJolVersionAccessors;
        }

    }

    public static class OrgOpenjdkJolVersionAccessors extends VersionFactory  {

        private final OrgOpenjdkJolJolVersionAccessors vaccForOrgOpenjdkJolJolVersionAccessors = new OrgOpenjdkJolJolVersionAccessors(providers, config);
        public OrgOpenjdkJolVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.openjdk.jol.jol</b>
         */
        public OrgOpenjdkJolJolVersionAccessors getJol() {
            return vaccForOrgOpenjdkJolJolVersionAccessors;
        }

    }

    public static class OrgOpenjdkJolJolVersionAccessors extends VersionFactory  {

        public OrgOpenjdkJolJolVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.openjdk.jol.jol.core</b> with value <b>0.16</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.openjdk.jol.jol.core"); }

    }

    public static class OrgSlf4jVersionAccessors extends VersionFactory  {

        private final OrgSlf4jSlf4jVersionAccessors vaccForOrgSlf4jSlf4jVersionAccessors = new OrgSlf4jSlf4jVersionAccessors(providers, config);
        public OrgSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jSlf4jVersionAccessors;
        }

    }

    public static class OrgSlf4jSlf4jVersionAccessors extends VersionFactory  {

        public OrgSlf4jSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.slf4j.slf4j.api</b> with value <b>2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.slf4j.slf4j.api"); }

        /**
         * Version alias <b>org.slf4j.slf4j.simple</b> with value <b>2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSimple() { return getVersion("org.slf4j.slf4j.simple"); }

    }

    public static class OrgSonatypeVersionAccessors extends VersionFactory  {

        private final OrgSonatypePlexusVersionAccessors vaccForOrgSonatypePlexusVersionAccessors = new OrgSonatypePlexusVersionAccessors(providers, config);
        public OrgSonatypeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonatype.plexus</b>
         */
        public OrgSonatypePlexusVersionAccessors getPlexus() {
            return vaccForOrgSonatypePlexusVersionAccessors;
        }

    }

    public static class OrgSonatypePlexusVersionAccessors extends VersionFactory  {

        private final OrgSonatypePlexusPlexusVersionAccessors vaccForOrgSonatypePlexusPlexusVersionAccessors = new OrgSonatypePlexusPlexusVersionAccessors(providers, config);
        public OrgSonatypePlexusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonatype.plexus.plexus</b>
         */
        public OrgSonatypePlexusPlexusVersionAccessors getPlexus() {
            return vaccForOrgSonatypePlexusPlexusVersionAccessors;
        }

    }

    public static class OrgSonatypePlexusPlexusVersionAccessors extends VersionFactory  {

        private final OrgSonatypePlexusPlexusBuildVersionAccessors vaccForOrgSonatypePlexusPlexusBuildVersionAccessors = new OrgSonatypePlexusPlexusBuildVersionAccessors(providers, config);
        public OrgSonatypePlexusPlexusVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonatype.plexus.plexus.build</b>
         */
        public OrgSonatypePlexusPlexusBuildVersionAccessors getBuild() {
            return vaccForOrgSonatypePlexusPlexusBuildVersionAccessors;
        }

    }

    public static class OrgSonatypePlexusPlexusBuildVersionAccessors extends VersionFactory  {

        public OrgSonatypePlexusPlexusBuildVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.sonatype.plexus.plexus.build.api</b> with value <b>0.0.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.sonatype.plexus.plexus.build.api"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
