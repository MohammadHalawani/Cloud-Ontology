;; #+TITLLE: Cloud Ontology

;; #+BEGIN_HTML
;; <script>
;; function showHide(shID) {
;; 	if (document.getElementById(shID)) {
;; 		if (document.getElementById(shID).style.display == 'none') {
;; 			document.getElementById(shID).style.display = 'block';
;; 		}
;; 		else {
;; 		        document.getElementById(shID).style.display = 'none';
;; 		}
;; 	}
;; }
;; </script>
;; #+END_HTML

;; Here is a documentation of the Cloud Ontology. Cloud ontology is a
;; model that describe all kinds of the clouds and their
;; classifications in a form of ontology classes and
;; sub-classes. There are many model of classification and in this
;; ontology we rely on the UK metofficey classification.

;; * Introduction
;; The ontology is created and built by Mohammad Halawani using
;; Tawny-OWL which is developed by Dr Phillip Lord from Newcastle
;; University.
;; /Copyright (C) 2017/

;; This document can be used as a referenceto learn all kinds of
;; clouds, as well as understand how the clouds are formed and
;; classified according to a certain criteria.

;; The purpose of the Cloud ontology is;

;; * How clouds form

;; * Classification of clouds
;; Following the International Cloud Atlas the cloud forms are
;; classified in terms of genera, species and varieties

;; #+BEGIN_HTML
;; <button onclick="showHide('code');">Show/Hide Tawny-OWL</button>
;; #+END_HTML

;; #+BEGIN_HTML
;; <div id="code" style="display: none;">
;; #+END_HTML

;; #+begin_src clojure
(ns clouds.core
  (:use [tawny owl pattern util])
  (:require [tawny.lookup :as l]
            [tawny.reasoner :as r]
            [tawny.query :as q]
            [clojure.string :as str]))
;; #+end_src

;; #+BEGIN_HTML
;; </div>
;; #+END_HTML

;; * Introduction
;; The ontology is created and built by Mohammad Halawani using
;; Tawny-OWL which is developed by Dr Phillip Lord from Newcastle
;; University.
;; /Copyright (C) 2017/

;; This document can be used as a referenceto learn all kinds of
;; clouds, as well as understand how the clouds are formed and
;; classified according to a certain criteria.

;; The purpose of the Cloud ontology is;

;; * How clouds form

;; * Classification of clouds
;; Following the International Cloud Atlas the cloud forms are
;; classified in terms of genera, species and varieties

;; #+BEGIN_HTML
;; <button onclick="showHide('code');">Show/Hide Tawny-OWL</button>
;; #+END_HTML

;; #+BEGIN_HTML
;; <div id="code" style="display: none;">
;; #+END_HTML


;; #developer comment:
;; This is from the UK metoffice clouds factsheet
;; http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf

;; #+begin_src clojure
(defontology cloud-ontology
    :iri "http://www.ncl.ac.uk/cloud")
;; #+end_src

;; #+BEGIN_HTML
;; </div>
;; #+END_HTML

;; #developer comment:
;; Define the classes that shape the ontology
;; These are the building blocks classes that are used to build other
;; classes upon. So, they are not the only subclasses of thing

;; #+begin_src clojure
(declare-classes AltitudeLevel
                 AtmosphericLayer
                 ClassificationMethod
                 Location
                 Origin
                 Feature
                 Cloud
                 FormationMethod)
;; #+end_src

;; #developer comment:
;; Build the rest of the subclasses without adding their T-Box axioms
;; Partitioning values

;; #+begin_src clojure
(deftier AltitudeLevel
  [
   Extreme
   High
   Low
   Medium
   SurfaceBased
   VeryHigh
   ]
  :suffix :Level
  :functional false
  :comment "Some clouds usually have their bases in the low
           level but may reach into the medium or high levels.  When
           the height of the base of a particular cloud is known, the
           use of levels may assis the observer to identify the
           cloud."
  :annotation
  (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=8"))
;; #+end_src

;; #+begin_src clojure
(deftier AtmosphericLayer
  [
   ExosphereLayer
   MesosphereLayer
   StratosphereLayer
   ThermosphereLayer
   TroposphereLayer
   ]
  :functional false
  :annotation (see-also "https://en.wikipedia.org/wiki/Atmosphere_of_Earth#Principal_layers"))
;; #+end_src


;; * Classification of clouds
;; Following the International Cloud Atlas the cloud forms are
;; classified in terms of of genera, species and varieties.

;; #+begin_src clojure
(deftier ClassificationMethod
  [
   Genus
   Species
   Variety
   ]
  :functional false
  :cover false
  :comment "Following the International Cloud Atlas, the
           cloud forms are classified in terms of gener,
           species and varieties."
  :annotation
  (see-also "http://www.metoffice.gov.uk/factsheet-1_clouds.pdf#page=9"))
;; #+end_src


;; ** Genera
;; Cloud forms are divided into 10 main groups, called genera. A given
;; cloud belongs to only one genus.
;; The genera, together with their accepted form of abbreviation, are:

;; #+begin_src clojure
(deftier Genus
  [
   Altocumulus
   Altostratus
   Cirrocumulus
   Cirrostratus
   Cirrus
   Cumulonimbus
   Cumulus
   Nimbostratus
   Stratocumulus
   Stratus
   ]
  :cover false
  :annotation
  (see-also "http://www.metoffice.gov.uk/factsheet-1_clouds.pdf#page=9")
  :comment "Clouds Formation")
;; #+end_src

;; ** Species
;; Peculiarities in the shape of clouds and differences in their
;; internal structure have led to the subdivision of most of the cloud
;; genera into species. Altostratus and nimbostratus are the only
;; genera which are not so divided. The full list of cloud species is:

;; #+begin_src clojure
(deftier Species
  [
   Calvus
   Capillatus
   Castellanus
   Congestus
   Fibratus
   Floccus
   Fractus
   Humilis
   Lenticularis
   Mediocris
   Nebulosus
   Spissatus
   Stratiformis
   Uncinus
   ]
  :functional false
  :cover false
  :annotation
  (see-also "http://www.metoffice.gov.uk/factsheet-1_clouds.pdf#page=10")
  :comment "Differences in the outer shape and inner structure of the clouds")
;; #+end_src

;; ** Varieties
;; Special features in appearance and degree of transparency of clouds
;; have led to the concept of varieties. For example, a cloud with a
;; definite wave characteristic would be termed ‘undulatus’ as in
;; undulating.
;; The full list of cloud varieties is:

;; #+begin_src clojure
(deftier Variety
  [
   Opacity
   Pattern
   [Genitus :comment "Xgenitus: formed by the spreading out of X mother clouds,
           e.g. stratocumulus Cumulogenitus  a stratocumulus formed by
           the spreading out of cumulus mother clouds"
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Mutatus_mother_clouds")]
   [Mutatus :comment "Xmutatus: formed by changing X mother clouds to another type,
           e.g. Cumulonimbus Cumulomutatus  a cumulonimbus formed by
           changing cumulus mother clouds"
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Mutatus_mother_clouds")]
   ]
  :functional false
  :cover false
  :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=11")
  :comment "Appearance and degree of transparency of clouds")
;; #+end_src

;; and in deeper view, we divided the following two varieties into
;; subclasses as follows:
;; Note: not using deftier, because deftier defines an
;; object property along with the defined tier which is not needed now.

;; *** Opacity

;; #+begin_src clojure
(as-disjoint-subclasses Opacity
                        (declare-classes Opacus
                                         Perlucidus
                                         Translucidus))
(refine Opacity
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_varieties"))
;; #+end_src

;; *** Pattern

;; #+begin_src clojure
(as-disjoint-subclasses Pattern
                        (declare-classes Duplicatus
                                         Intortus
                                         Lacunosus
                                         Radiatus
                                         Undulatus
                                         Vertebratus))
(refine Pattern
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_varieties"))
;; #+end_src

;; ** Cloud class:
;; Here we define three different types of the clouds, Accessory clouds,
;; special clouds and other clouds.

;; #+begin_src clojure
(as-disjoint-subclasses Cloud
                        (declare-classes AccessoryCloud
                                         SpecialCloud
                                         OtherCloud))
;; #+end_src

;; *** Accessory clouds:
;; are small clouds which may be separate or partly merged with the main cloud.

;; #+begin_src clojure
(as-disjoint-subclasses AccessoryCloud
                        (declare-classes Pannus
                                         Pileus
                                         Velum))
(refine AccessoryCloud
           :comment "The cloud may be accompanied by other, usually smaller,
                            clouds which are known as accessory clouds and which may be
                            separate or partly merged with the main cloud"
           :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=44"))
;; #+end_src

;; *** Special clouds
;; Nacreous and noctilucent clouds occur at high altitudes and may be
;; observed from comparatively restricted geographical locations. Both
;; may be seen from the British Isles but usually only in the higher
;; latitudes.

;; #+begin_src clojure
(as-disjoint-subclasses SpecialCloud
                        (declare-classes Nacreous
                                         Noctilucent))
(refine SpecialCloud
           :comment "Special clouds (Nacreous and Noctilucent)
                                     occur at high altitudes and high latitudes"
           :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=50"))
(defclass MotherOfPearl :equivalent Nacreous)
;; #+end_src

;; *** Other clouds
;; some other clouds are defined below:

;; #+begin_src clojure
(as-disjoint-subclasses  OtherCloud
                         (declare-classes Contrails
                                          Fumulus
                                          OrographicCloud
                                          Pyrocumulus
                                          FallstreakHole
                                          Kelvin-Helmholtz
                                          RollCloud))
(defclass Aviaticus :equivalent Contrails)
;; #+end_src

;; * Features:
;; Some features defined to be added to clouds accordingly. Each
;; feature has many different subclasses which will be added later.

;; #+begin_src clojure
(deftier Feature
  [
   Colour
   Form
   RainBearing
   Shape
   SupplementaryFeature
   ]
  :functional false
  :cover false
  )
;; #+end_src

;; *** Colour feature
;; For example, colour feature has the following main terms:

;; #+begin_src clojure
(deftier Colour
  [
   Opaque
   SemiTransparent
   Transparent
   ]
  :functional false
  :cover false
  )
;; #+end_src

;; then opaque colour is divided as:

;; #+begin_src clojure
(as-disjoint-subclasses Opaque
                        (declare-classes Bluish
                                         Grey
                                         OrangeReddish
                                         Pink
                                         Silvery))
;; #+end_src

;; and semi-transparent is divided into:

;; #+begin_src clojure
(as-disjoint-subclasses SemiTransparent
                        (declare-classes Muzzy
                                         RainbowColour))
;; #+end_src

;; Also we use different terminologies for the same class, such as:

;; #+begin_src clojure
(as-equivalent Muzzy (declare-classes Blurry Foggy Fuzzy Hazy))
;; #+end_src

;; *** Form feature:

;; #+begin_src clojure
(deftier Form
  [
   Altiform
   Cirriform
   Cumuliform
   Nimbiform
   Stratiform
   ]
  :functional false
  :cover false
  :comment "Used to link clouds' genus, species or varieties
            to their shapes and other characterisitics")
;; #+end_src

;; *** Shape feature:
;; Different shapes for the clouds along with some synonems for the shapes

;; #+begin_src clojure
(deftier Shape
  [
   AnvilLike
   ArchLike
   Broken
   Bulges
   CapLike
   CommaLike
   Cone
   Curly
   Crested
   Densified
   Elongated
   FiberLike
   FishSkeletonLike
   Flat
   Holed
   Honeycomb
   Horizontal
   JellyfishLike
   Layered
   LensLike
   Net
   Parallel
   RadiationLike
   Rounded
   Smooth
   Spaced
   Steriated
   Superposed
   Tangled
   TornadoLike
   TubeLike
   UdderLike
   Undualated
   Vertical
   ]
  :functional false
  :cover false
  )
(as-equivalent Broken (declare-classes Shreded Fractioned Ragged))
(as-equivalent CommaLike (declare-classes Hooky))
(as-equivalent Cone (declare-classes Funnel))
(as-equivalent Curly (declare-classes FlakesLike Wispy Tufty))
(as-equivalent FishSkeletonLike (declare-classes RibsLike VertebraeLike))
(as-equivalent Vertical (declare-classes HeapedUp))
(as-equivalent TornadoLike (declare-classes VortexLike WhirlpoolLike))
(as-equivalent Undualated (declare-classes Wavy))
;; #+end_src

;; **** Rounded shapes:

;; #+begin_src clojure
(as-disjoint-subclasses Horizontal
                        (declare-classes GreatHorizontal
                                         SmallHorizontal))
;; #+end_src

;; **** Horizontal shapes:

;; #+begin_src clojure
(as-disjoint-subclasses Rounded
                        (declare-classes CauliflowerLike
                                         Puffy))
;; #+end_src

;; **** Vertical shapes:

;; #+begin_src clojure
(defclass VerticallySteriated :super Steriated)

(as-disjoint-subclasses Vertical
                        (declare-classes CastleLike
                                         CongestingVertical
                                         LowVertical
                                         MediumVertical))
(as-equivalent CongestingVertical (declare-classes GreatVertical TallVertical ToweringVertical))
(as-equivalent LowVertical (declare-classes ShortVertical SlightVertical))
(as-equivalent MediumVertical (declare-classes ModerateVertical))
;; #+end_src

;; *** Supplementary Features:

;; #+begin_src clojure
(deftier SupplementaryFeature
  [
   Arcus
   Incus
   Mamma
   Precipitation
   Tuba
   ]
  :functional false
  :cover false
  :comment "The indication of genus, species and variety is
           not always sufficient to describe the cloud completely. The
           cloud may sometimes have supplementary features"
  :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=44"))

(defclass  Mammatus :equivalent Mamma)
;; #+end_src

;; **** Precipitation:

;; #+begin_src clojure
(as-disjoint-subclasses Precipitation
                        (declare-classes Praecipitatio
                                         Virga))

(defclass  Fallstreak :equivalent Virga)
;; #+end_src

;; ***** Precipitatio:

;; #+begin_src clojure
(as-disjoint-subclasses Praecipitatio
                        (declare-classes Drizzle
                                         Hail
                                         Rain
                                         Snow))
;; #+end_src

;; * Formation method:
;; Clouds are formed by raising hot air, spreading or lowering other clouds, etc.

;; #+begin_src clojure
(deftier FormationMethod
  [
   Lowering
   Raising
   Spreading
   ]
  :functional false
  :cover false
  )
(defclass Uplifting :equivalent Raising)
;; #+end_src

;; * Location:
;; The location of supplementary features and accessory clouds in relation to the main cloud

;; #+begin_src clojure
(deftier Location
  [
   Attached
   Detached
   InCloud
   ]
  :functional false
  :cover false
  :comment "Supplementary features and accessory clouds may
           occur at any level of the cloud"
  :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=44"))
;; #+end_src

;; The locations can be devided in more details as follows:

;; #+begin_src clojure
(as-subclasses Attached
               (defclass AttachedToBack)
               (defclass AttachedToFront :disjoint AttachedToBack)
               (defclass AttachedToBase)
               (defclass AttachedToTop :disjoint AttachedToBase))
(as-subclasses Detached
               (defclass Above)
               (defclass Below :disjoint Above)
               (defclass InFront)
               (defclass Behind :disjoint InFront))
(as-subclasses InCloud
               (defclass Back)
               (defclass Front :disjoint Back)
               (defclass Base)
               (defclass Top :disjoint Base))
;; #+end_src

;; * Origin:
;; The origin which caused the formation of clouds

;; #+begin_src clojure
(deftier Origin
  [
   AircraftEngineExhaust
   Fume
   IntenseHeat
   Orographic
   ]
  :functional false
  :cover false
  )
;; #+end_src

;; #developer comment:
;; Refine object properties for the building blocks classes (superproperties)

;; #+begin_src clojure
(refine hasOrigin
  :range (owl-or Origin Genus)
  :characteristic :transitive)
(refine hasFeature
  :characteristic :transitive)
(refine hasFormationMethod
  :characteristic :transitive)
;; #+end_src

;; #developer comment:
;; Define other object property

;; #+begin_src clojure
(defoproperty attachedTo
  :range Cloud
  :characteristic :transitive)
(defoproperty hasAttachment
  :range Cloud
  :characteristic :transitive)
(defoproperty bornOf
  :range Genus
  :super hasOrigin)
(defoproperty changedFrom
  :range Genus
  :super hasOrigin)
(refine hasGenus
  :super hasClassificationMethod)
(refine hasSpecies
  :super hasClassificationMethod)
(refine hasVariety
  :super hasClassificationMethod)
(refine hasColour
  :super hasFeature)
(refine hasSupplementaryFeature
  :super hasFeature
  :characteristic :transitive)
;; #+end_src

;; #developer comment:
;; Object properties including a subproperty chain

;; #+begin_src clojure
(refine hasForm
        :super hasFeature
        :characteristic :transitive
        :subchain [[hasGenus hasForm]
                   [hasSpecies hasForm]
                   [hasVariety hasForm]])
(refine hasShape
        :super hasFeature
        :characteristic :transitive
        :subchain [[hasForm hasShape]
                   [hasGenus hasShape]
                   [hasSpecies hasShape]
                   [hasVariety hasShape]])
;; #+end_src

;; #developer comment:
;; These 4 properties are defined here (not at the begining)
;; because they rely on other properties (e.g. hasForm) that are just have been defined

;; #+begin_src clojure
(refine hasAltitudeLevel
        :subchain [[hasForm hasAltitudeLevel]
                   [hasGenus hasAltitudeLevel]
                   [hasSpecies hasAltitudeLevel]
                   [hasVariety hasAltitudeLevel]])
(refine hasAtmosphericLayer
        :subchain hasAltitudeLevel hasAtmosphericLayer)
(defoproperty bornOf)
(refine bornOf
        :range Genus
        :super hasOrigin
        :subchain hasVariety bornOf)
(defoproperty changedFrom)
(refine changedFrom
        :range Genus
        :super hasOrigin
        :subchain hasVariety changedFrom)
;; #+end_src

;; #developer comment:
;; countinuing object properties

;; #+begin_src clojure
(defoproperty hasTopShape
  :range Shape
  :super hasShape
  :characteristic :transitive)
(defoproperty hasBaseShape
  :range Shape
  :super hasShape
  :characteristic :transitive)
(defoproperty hasOverallShape
  :range Shape
  :super hasShape
  :characteristic :transitive)
(defoproperty hasTopLocation
  :range Location
  :super hasLocation)
(defoproperty hasBaseLocation
  :range Location
  :super hasLocation)
;; #+end_src

;; #developer comment:
;; Dataproperties

;; #+begin_src clojure
(defdproperty hasHeight      :range :XSD_DOUBLE)
(defdproperty hasLatitude    :range :XSD_DOUBLE)
(defdproperty hasTemperature :range :XSD_DOUBLE)
;; #+end_src

;; #developer comment:
;; Annotation properties

;; #+begin_src clojure
(defaproperty relatedTerm)
(def related (annotator relatedTerm))
(defaproperty reference)
(def ref-link (annotator reference))
(defaproperty photo)
(def photo (annotator photo))
(defaproperty classificationSymbol)
(def with-symbol (annotator classificationSymbol))
(defaproperty pronunciation)
(def pronounce (annotator pronunciation))
;; #+end_src

;; developer comment:
;; After defining the hasGenus object property, we can specify that
;; each cloud can only have one genus
 
;; #+begin_src clojure
(refine Cloud
;           :super (exactly 1 hasGenus)
           :annotation (see-also "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=9")
           :comment "A given cloud belongs to only one genus")
;; #+end_src

;; #developer comment:
;; Create a function (underlying function)for the properties to use instead of using (property some) form

;; #+begin_src clojure
(defn propertyFunc   [prprty cls & clses]
  (let [clsesVector (first (first clses))]
    (if (vector? clsesVector)
      (refine cls :super (owl-some prprty clsesVector))
      (if (or (empty? clses) (every? nil? clses))
        (owl-some prprty cls)
        (owl-some prprty cls clses)))))

;; #+end_src

;; #developer comment:
;; Create a function (underlying function) for the data properties to use instead of using (property value) form

;; #+begin_src clojure
(defn valueFunc
  ([prprty value]
   (data-has-value prprty value))
  ([prprty cls value]
   (refine cls :super (data-has-value prprty value))))
;; #+end_src

;; #developer comment:
;; Creating short functions (relying on the propertyfunc)to use
;; A macro is used to create these functions.

;; #developer comment:
;; First, shorten properties' names to use as names for the created functions


;; #+begin_src clojure
;; convert the property to a function's name
;; (all lower-case letters with hyphenated words
;; e.g. hasSupplementaryfeature -> supplementary-feature)
(defn shorten [prprty]
  (let [s (str prprty)
        s (str/replace-first s #"has(.+)" "$1")
        s (str/replace       s #"(Level|Layer|Method)" "")
        s (str/replace       s #"([A-Z])" (str "-" "$1"))
        startsWithdash (str/starts-with?  s "-")
        s (if startsWithdash (str/replace-first s "-" "") s)
        s (str/lower-case s)]
    s))
;; #+end_src

;; #developer comment:
;; Then, create named functions

;; #+begin_src clojure
(defn shortenProperty [prprty]
  `(defn ~(symbol (shorten prprty)) [cls# & clses#]
     (propertyFunc ~prprty cls# clses#)))
;; #+end_src

;; #developer comment:
;; Finally, a macro that takes a vector of properties and converts them to functions

;; #+begin_src clojure
(defmacro mkfn [prprties]
     `(do ~@(map shortenProperty prprties)))
;; #+end_src


;; #developer comment:
;; A macro is evaluated in compile time rather than run time.
;; Hence, you cannot pass it a variable; because it will take the variable's symbol itself
;; rather than its value (as the value is known at run time)

;; #+begin_src clojure
(mkfn [
        hasClassificationMethod
        hasLocation
        hasOrigin
        hasFeature
        hasFormationMethod
        attachedTo
        hasAttachment
        hasGenus
        hasSpecies
        hasVariety
        hasColour
        hasSupplementaryFeature
        hasForm
        hasShape
        hasAltitudeLevel
        hasAtmosphericLayer
        bornOf
        changedFrom
        hasTopShape
        hasBaseShape
        hasOverallShape
        hasTopLocation
        hasBaseLocation
        hasHeight
        hasLatitude
        hasTemperature
        ])
;; #+end_src

;; ** Defined clouds:
;; Clouds defined by form

;; #+begin_src clojure
(defclass CumuliformCloud  :equivalent (owl-and Cloud (facet Cumuliform)))
(defclass NimbiformCloud  :equivalent (owl-and Cloud (facet Nimbiform)))
(defclass AltiformCloud  :equivalent (owl-and Cloud (facet Altiform)))
(defclass StratiformCloud  :equivalent (owl-and Cloud (facet Stratiform)))
(defclass CirriformCloud  :equivalent (owl-and Cloud (facet Cirriform)))
;; #+end_src

;; * Data properties:
;; ** Heights for Altitude levels

;; #+begin_src clojure
(refine AltitudeLevel :comment "Hights are measured from the sea-level to the base of the cloud. Heights are taken from the table"
           :annotation (ref-link "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=9"))
(height SurfaceBasedLevel [(span <  0.05)])
(height LowLevel          [(span >< 0.05 2.0)])
(height MediumLevel       [(span >< 2.0  6.0)])
(height HighLevel         [(span >< 6.0  12.0)])
(height VeryHighLevel     [(span >< 20.0 30.0)])
(height ExtremeLevel      [(span >  75.0)])
;; #+end_src

;; ** Heights for atmospheric layers

;; #+begin_src clojure
(height TroposphereLayer  [(span >< 0.0   12.0)])
(height StratosphereLayer [(span >< 12.0  50.0)])
(height MesosphereLayer   [(span >< 50.0  80.0)])
(height ThermosphereLayer [(span >< 80.0  700.0)])
(height ExosphereLayer    [(span >< 700.0 10000.0)])
;; #+end_src

;; ** Heights for Special clouds

;; #+begin_src clojure
(height Nacreous          [(span >  21.0)])
(valueFunc hasHeight Noctilucent 80.0)
;; #+end_src

;; ** Latitude
;; for Noctilucent

;; #+begin_src clojure
(latitude Noctilucent [(span >  45.0)])
;; #+end_src

;; ** Temprature
;; for Nacreous

;; #+begin_src clojure
(valueFunc hasTemperature Nacreous -90.0)
;; #+end_src


;; * Object properties:

(defn propertyFunc   [prprty cls & clses]
  (let [clsesVector (first (first clses))]
    (if (vector? clsesVector)
      (refine cls :super (owl-some prprty clsesVector))
      (if (or (empty? clses) (every? nil? clses))
        (owl-some prprty cls)
        (owl-some prprty cls clses)))))

(defn facet2 [ cls & clses]
  (let [clsesVector (first (first clses))]
    (if (vector? clsesVector)
      (refine cls :super (facet clsesVector))
      (if (or (empty? clses) (every? nil? clses))
        (facet cls)
        (refine cls :super (facet clses))))))


;; #developer comment:
;; Linking with alt-level

;; ** Altitude level
;; *** Genus

;; #+begin_src clojure
(as-subclasses (altitude HighLevel)
               Cirrus Cirrocumulus Cirrostratus)
(as-subclasses (altitude MediumLevel)
               Altocumulus Altostratus)
(as-subclasses (altitude LowLevel)
               Stratus Stratocumulus Cumulus Cumulonimbus)
(altitude Nimbostratus [(owl-or LowLevel MediumLevel)])
;; #+end_src

;; *** Special clouds

;; #+begin_src clojure
(altitude Nacreous    [VeryHighLevel])
(altitude Noctilucent [ExtremeLevel])
;; #+end_src

;; *** Form

;; #+begin_src clojure
(altitude Altiform [MediumLevel])
(altitude Cirriform [HighLevel])
;; #+end_src

;; *** Supplementary features

;; #+begin_src clojure
(altitude Praecipitatio [SurfaceBasedLevel])
;; #+end_src

;; #developer comment:
;; Linking with alt-level in a different way because of the not

;; #+begin_src clojure
(refine Virga :super (owl-not (owl-some hasAltitudeLevel SurfaceBasedLevel)))
;; #+end_src

;; #developer comment:
;; Linking with atmosphericlayer

;; ** Atmospheric Layer
;; *** alt-level

;; #+begin_src clojure
(as-subclasses (atmospheric TroposphereLayer)
               SurfaceBasedLevel LowLevel MediumLevel HighLevel)
(atmospheric VeryHighLevel [StratosphereLayer])
(atmospheric ExtremeLevel [(owl-or MesosphereLayer ThermosphereLayer ExosphereLayer)])
;; #+end_src

;; #developer comment:
;; Linking with Form

;; ** Form
;; *** Genus

;; #+begin_src clojure
(as-subclasses (form Altiform)
               Altocumulus Altostratus)
(as-subclasses (form Cirriform)
               Cirrocumulus Cirrostratus Cirrus)
(as-subclasses (form Nimbiform)
               Cumulonimbus Nimbostratus)
(as-subclasses (form Stratiform)
               Altostratus Cirrostratus Nimbostratus Stratocumulus Stratus)
(as-subclasses (form Cumuliform)
               Altocumulus Cirrocumulus Cumulonimbus Cumulus Stratocumulus)
;; #+end_src

;; *** Species

;; #+begin_src clojure
(form Floccus [Cumuliform])
(form Castellanus [(owl-and Cumuliform (location Top))])
(form Stratiformis [Stratiform])
;; #+end_src

;;  *** Varieties
;; #developer comment:
;; If a cloud is born from another cloud, it does not have to have the form of its origin

;; #+begin_comment
;; #+begin_src clojure
;; (form Cumulogenitus [Cumuliform])
;; #+end_src
;; #+end_comment

;; #developer comment:
;; Now, It's easier to countinue the axioms on a class by class basis

;; * Subclasses of Thing

;; #+begin_src clojure
(height AltitudeLevel [:XSD_DOUBLE])
(height AtmosphericLayer [:XSD_DOUBLE])
;; #+end_src

;; ** Subclasses of ClassificationMethod
;; *** Genus:

;; #+begin_src clojure
(refine Altostratus
        :super (formation Lowering) (origin Nimbostratus)
        :comment "From the notes in the table"
        :annotation (ref-link "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=9"))
(refine Cirrostratus
        :super (formation Lowering) (origin Altostratus)
        :comment "From the notes in the table"
        :annotation (ref-link "http://www.metoffice.gov.uk/binaries/content/assets/mohippo/pdf/library/factsheets/12_0674-factsheet-1_clouds.pdf#page=9"))
(shape Cumulonimbus [ToweringVertical])
(shape Nimbostratus [ModerateVertical])
;; #+end_src

;; *** Species:

;; #+begin_src clojure
(shape Calvus [VerticallySteriated])
(shape Capillatus [AnvilLike (owl-or FiberLike Steriated)])
(shape Castellanus [CastleLike])
(shape Congestus [GreatVertical])
(top-shape Congestus [CauliflowerLike])
(shape Fibratus [FiberLike])
(shape Floccus [Tufty])
(base-shape Floccus [Ragged])
(shape Fractus [Fractioned])
(shape Humilis [SlightVertical])
(shape Lenticularis [LensLike Elongated])
(shape Mediocris [ModerateVertical])
(colour Nebulosus [Grey])
(shape Spissatus [Densified])
(colour Spissatus [Grey])
(shape Stratiformis [GreatHorizontal])
(shape Uncinus [CommaLike])
(top-shape Uncinus [(owl-or Hooky (owl-and Tufty (owl-not Rounded)))])
;; #+end_src

;; #developer comment:
;; different because of the not

;; #+begin_src clojure
(refine Fibratus :super (owl-not(owl-some hasTopShape (owl-or Hooky Tufty))))
;; #+end_src

;; *** Varieties:

;; #developer comment:
;; cumulogenitus is created with other genitus varieties
;; #+begin_comment
;; #+begin_src clojure
;(formation Cumulogenitus [Spreading])
;(origin Cumulogenitus [Cumulus])
;; #+end_src
;; #+end_comment

;; #+begin_src clojure
(shape Duplicatus [Superposed])
(shape Intortus [Tangled])
(shape Lacunosus [Holed Honeycomb Net])
(colour Opacus [Opaque])
(colour Perlucidus [Transparent])
(shape Perlucidus [Spaced])
(shape Radiatus [RadiationLike Parallel])
(colour Translucidus [SemiTransparent])
(shape Undulatus [Wavy])
(shape Vertebratus [VertebraeLike])
;; #+end_src

;; ** Subclasses of Cloud

;; #+begin_src clojure
(location AccessoryCloud [(owl-or Attached Detached)])
(origin OtherCloud [Origin])
;; #+end_src

;; *** Accessorycloud

;; #+begin_src clojure
(refine Pannus :super
           (location (owl-or AttachedToBase Below))
           (shape Shreded))
(refine Pileus :super
           (location (owl-or AttachedToTop Above))
           (attachment CumuliformCloud)
           (shape SmallHorizontal CapLike))
(refine Velum :super
           (location (owl-or AttachedToTop Above))
           (attachment CumuliformCloud)
           (shape GreatHorizontal))
;; #+end_src

;; ***  OtherClouds

;; #+begin_src clojure
(refine Contrails
           :super (origin AircraftEngineExhaust)
           :comment "An informal term officially proposed for WMO classification.
See https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification"
           :comment "Proposed as a WMO genitus variety."
           :annotation (label "Homogenitus" "latin")
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification")
           :annotation (related Genitus)
           )
(refine Fumulus :super
           (origin Fume)
           (form Cumuliform))
(refine OrographicCloud :super
           (origin Orographic)
           (formation Uplifting))
(refine Pyrocumulus :super
           (origin IntenseHeat)
           (form Cumuliform)
           :comment "An informal term officially proposed for WMO classification.
See https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification"
           :comment "Proposed as a WMO genitus variety."
           :annotation (label "Flammagenitus" "latin")
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification")
           :annotation (related Genitus)
           )
(refine FallstreakHole :super
           (shape Holed)
           (supplementary-feature Virga)
           :comment "An informal term officially proposed for WMO classification.
See https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification"
           :comment "Proposed as a WMO supplementary feature."
           :annotation (label "Cavus" "latin")
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification")
           :annotation (related SupplementaryFeature)
           )
(refine Kelvin-Helmholtz :super
           (shape Crested Wavy)
           (atmospheric TroposphereLayer)
           :comment "An informal term officially proposed for WMO classification.
See https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification"
           :comment "Proposed as a WMO supplementary feature."
           :annotation (label "Fluctus" "latin")
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification")
           :annotation (related SupplementaryFeature)
           )
(refine RollCloud :super
           (shape TubeLike)
           :comment "An informal term officially proposed for WMO classification.
See https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification"
           :comment "Proposed as a WMO stratocumulus species."
           :annotation (label "Volutus" "latin")
           :annotation (see-also "https://en.wikipedia.org/wiki/List_of_cloud_types#Informal_terms_officially_proposed_for_WMO_classification")
           :annotation (related Species) (related Stratocumulus)
           )
;; #+end_src

;; *** Specialcloud

;; #+begin_src clojure
(refine Noctilucent :super
           (atmospheric MesosphereLayer)
           (colour (owl-or Bluish  OrangeReddish  Pink  Silvery)))
(refine Nacreous :super
           (atmospheric StratosphereLayer)
           (shape Lenticularis)
           (colour (owl-or Grey  OrangeReddish  Pink  RainbowColour)))
;; #+end_src

;; *** VirgaCloud

;; #+begin_src clojure
(defclass VirgaCloud :super
  Cloud
  (overall-shape JellyfishLike)
  (supplementary-feature Virga))
;; #+end_src

;; ** Subclasses of Feature

;; #+begin_src clojure
(location SupplementaryFeature [Attached])
;; #+end_src

;; *** Form:

;; #+begin_src clojure
(top-shape Cirriform [Tufty])
(feature Nimbiform [RainBearing])
(shape Stratiform [Flat Horizontal Layered Smooth])
(refine Cumuliform :equivalent (owl-and Form (shape CauliflowerLike Puffy Vertical)))
;; #+end_src

;; *** SupplementaryFeature

;; #+begin_src clojure 
(refine Arcus :super
           (location (owl-and AttachedToBase AttachedToFront))
           (shape ArchLike))
(refine Incus :super
           (location AttachedToTop)
           (shape AnvilLike (owl-or FiberLike Steriated)))
(refine Mamma :super
           (location AttachedToBase)
           (shape UdderLike Bulges))
(refine Tuba :super
           (location AttachedToBase)
           (shape Cone VortexLike))
(location Precipitation [AttachedToBase])
;; #+end_src

;; #developer comment:
;; Creating (genitus) and (mutatus)subclasses of variety from each genus

;; #developer comment:
;; First, define functins to creat (genitus) and (mutatus) classes for a given genus

;; #+begin_src clojure
(defn genitus [genus]
  (let [entity-name (str/replace (l/resolve-entity genus) "us" "ogenitus")]
    (intern-owl-string entity-name
                       (owl-class entity-name :super Genitus (born-of genus) (formation Spreading)))))
(defn mutatus [genus]
  (let [entity-name (str/replace (l/resolve-entity genus) "us" "omutatus")]
    (intern-owl-string entity-name
                       (owl-class entity-name :super Mutatus (changed-from genus)))))
;; #+end_src

;; #developer comment:
;; Then, we apply the functions on the subclasses of genus
;; to derive their (genitus) and (mutatus) versions

;; #+begin_src clojure
(domap genitus (subclasses Genus))
(domap mutatus (subclasses Genus))
;; #+end_src

;; #developer comment:
;; Creating clouds for each classification (Genus, Species, Variety,
;; Form, Altitudelevel and Atmosphericlayer)

;; #+begin_src clojure
(defn cloud-for-classification [classify]
  (let [entity-name (str (l/resolve-entity classify) "Cloud")
        super (direct-superclasses classify)
        cls classify]
    (intern-owl-string
     entity-name
     (owl-class
      entity-name
      :equivalent  (owl-and Cloud
                            (cond
                             (superclass? cls SupplementaryFeature)  (supplementary-feature cls)
                             (superclass? cls AccessoryCloud) (attachment cls)
                             (superclass? cls Genus) (genus cls)
                             (superclass? cls Species) (species cls)
                             (superclass? cls Variety) (variety cls)
                             (superclass? cls AltitudeLevel) (altitude cls)
                             (superclass? cls Form) (form cls)
                             (superclass? cls AtmosphericLayer) (atmospheric cls)))))))

(defn clouds-for-classifications [& cls]
  (domap cloud-for-classification (flatten (for [x (map subclasses cls)]
                             (for [cls x]
                               cls)))))
;; #+end_src

;; #+begin_src clojure
(clouds-for-classifications AltitudeLevel
                            AtmosphericLayer
                            Genus
                            Species
                            Form
                            AccessoryCloud
                            SupplementaryFeature)

(apply clouds-for-classifications (direct-subclasses Variety))
;; #+end_src

;; #developer comment:
;; Define an underlying function that creates clouds

;; #+begin_src clojure
(defn cloud
  [{:keys [genusCloud speciesCloud varietyCloudVector
           supplementaryFeatureCloudVector accessoryCloudVector
           coment annot]}]
  (let [genus (if genusCloud
                (str/replace (l/resolve-entity genusCloud) "Cloud" "") "")
        species (if speciesCloud
                  (str/replace (l/resolve-entity speciesCloud) "Cloud" "") "")
        varietyList (if varietyCloudVector
                        (dofor [variety varietyCloudVector]
                          (str/replace (l/resolve-entity variety) "Cloud" "")) "")
        supplementaryFeatureList (if supplementaryFeatureCloudVector
                        (dofor [supplementaryFeature supplementaryFeatureCloudVector]
                          (str/replace (l/resolve-entity supplementaryFeature) "Cloud" "")) "")
        accessoryList (if accessoryCloudVector
                        (dofor [accessory accessoryCloudVector]
                                 (str/replace (l/resolve-entity accessory) "Cloud" "")) "")
        related-terms (flatten [genus species varietyList supplementaryFeatureList accessoryList])
        entity-name (str genus
                         species
                         (str/join varietyList)
                         (str/join supplementaryFeatureList)
                         (str/join accessoryList) "Cloud")
        ]
    (let [clses (remove nil? [genusCloud speciesCloud varietyCloudVector
                              supplementaryFeatureCloudVector accessoryCloudVector])]
    (intern-owl-string entity-name
                       (owl-class entity-name
                                  :equivalent (owl-and clses)
                                  :comment    coment
                                  :annotation (dofor [a annot]
                                                       (ref-link a))
                                  :annotation (remove nil?
                                               (dofor [term related-terms]
                                                     (if (seq term)
                                                       (related (owl-class term)))))
                                  )))))
;; #+end_src

;; #develpoer comment
;; Define functions that create specific clouds with  annotations

;; #+begin_src clojure
(defn create-specific-cloud [{:keys [gen spec var feature accessory cmnt annot]}]
  (let [g (if gen
            (str/replace (l/resolve-entity gen) "Cloud" "") "")
        s (if spec
            (str/replace (l/resolve-entity spec) "Cloud" "") "")
        v (if var
            (str/replace (l/resolve-entity var) "Cloud" "") "")
        f (if feature
            (str/replace (l/resolve-entity feature) "Cloud" "") "")
        acce (if accessory
               (str/replace (l/resolve-entity accessory) "Cloud" "") "")
        ant (if annot annot
                (if (and (empty? acce)(empty? f)(empty? v) (seq s))
                   "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_species"
                   (if (seq v)
                     (if (or (str/ends-with? v "mutatus") (str/ends-with? v "genitus"))
                       "https://en.wikipedia.org/wiki/List_of_cloud_types#Mutatus_mother_clouds"
                       "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_varieties")
                     (if (not (and (empty? acce)(empty? f)))
                       "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_supplementary_features"))))
        cmnt-pt1 (if (empty? cmnt)
                   (str "From the "
                      (if (str/includes? g "Cumulus")
                           (if (str/includes? s "Congestus")
                             (str g " (TV)")
                             (if (str/includes? s "Mediocris")
                               (str g " (MV)")
                               (if (str/includes? s "Humilis")
                                 g)))
                           g)
                      " genus row and the "))
        cmnt-pt2 (if (empty? cmnt)
                   (if (and (empty? acce)(empty? f)(empty? v) (seq s))
                   (str s " species column in the following table
https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_species")
                   (if (seq v)
                     (if (str/ends-with? v "mutatus")
                                       (str (str/replace v "mutatus" "")
                                            " variety column under
                                            Mutatus Mother column in
                                            the following table
https://en.wikipedia.org/wiki/List_of_cloud_types#Mutatus_mother_clouds")
                                       (if (str/ends-with? v "genitus")
                                         (str (str/replace v "genitus" "")
                                              " variety column under
                                              Genitus Mother column
                                              in the following table
https://en.wikipedia.org/wiki/List_of_cloud_types#Mutatus_mother_clouds")
                                         (str v " variety column in the following table
https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_varieties")))
                     (if (seq acce)
                       (str acce " column in the following table")
                       (if (seq f)
                         (str f " column in the following table"))))))
        comment-annot {:a ant :com (if (seq cmnt) cmnt (str cmnt-pt1 cmnt-pt2))}]
    (if (and (empty? acce)(empty? f)(empty? v) (seq s))
      (cloud {:genusCloud gen
              :speciesCloud spec
              :coment (get comment-annot :com)
              :annot [(get comment-annot :a)]})
      (if (and (empty? acce)(empty? f)(seq v)(empty? s))
        (cloud {:genusCloud gen
                :varietyCloudVector [var]
                :coment (get comment-annot :com)
                :annot [(get comment-annot :a)]})
        (if (and (empty? acce)(empty? f)(seq v)(seq s))
          (cloud {:genusCloud gen
                  :speciesCloud spec
                  :varietyCloudVector [var]
                  :coment (get comment-annot :com)
                  :annot [(get comment-annot :a)]})
      (if (and (empty? acce)(empty? v)(seq f)(empty? s))
        (cloud {:genusCloud gen
                :supplementaryFeatureCloudVector [feature]
                :coment (get comment-annot :com)
                :annot [(get comment-annot :a)]})
        (if (and (empty? acce)(empty? v)(seq f)(seq s))
          (cloud {:genusCloud gen
                  :speciesCloud spec
                  :supplementaryFeatureCloudVector [feature]
                  :coment (get comment-annot :com)
                  :annot [(get comment-annot :a)]})
      (if (and (empty? v)(empty? f)(seq acce)(empty? s))
        (cloud {:genusCloud gen
                :accessoryCloudVector [accessory]
                :coment (get comment-annot :com)
                :annot [(get comment-annot :a)]})
        (if (and (empty? v) (empty? f)(seq acce)(seq s))
          (cloud {:genusCloud gen
                  :speciesCloud spec
                  :accessoryCloudVector [accessory]
                  :coment (get comment-annot :com)
                  :annot[(get comment-annot :a)]}))))))))))
;; #+end_src

;; #+begin_src clojure
(defn create-specific-clouds [{:keys [gen spec var feature accessory cmnt annot]}]
    (if (and (empty? accessory)(empty? feature)(empty? var) (seq spec))
      (doseq [g gen
              s spec]
        (create-specific-cloud {:gen g
                                :spec s
                                :annot annot
                                :cmnt cmnt}))
      (if (and (empty? accessory)(empty? feature)(seq var)(empty? spec))
      (doseq [g gen
              v var]
        (create-specific-cloud {:gen g
                                :var v
                                :annot annot
                                :cmnt cmnt}))
        (if (and (empty? accessory)(empty? feature)(seq var)(seq spec))
      (doseq [g gen
              s spec
              v var]
          (create-specific-cloud {:gen g
                                  :spec s
                                  :var v
                                  :annot annot
                                  :cmnt cmnt}))
          (if (and (empty? accessory)(empty? var)(seq feature)(empty? spec))
      (doseq [g gen
              f feature]
            (create-specific-cloud {:gen g
                                    :feature f
                                    :annot annot
                                    :cmnt cmnt}))
            (if (and (empty? accessory)(empty? var)(seq feature)(seq spec))
      (doseq [g gen
              s spec
              f feature]
              (create-specific-cloud {:gen g
                                      :spec s
                                      :feature f
                                      :annot annot
                                      :cmnt cmnt}))
              (if (and (empty? var)(empty? feature)(seq accessory)(empty? spec))
      (doseq [g gen
              acce accessory]
                (create-specific-cloud {:gen g
                                        :accessory acce
                                        :annot annot
                                        :cmnt cmnt}))
      (if (and (empty? var) (empty? feature)(seq accessory)(seq spec))
        (doseq [g gen
              s spec
              acce accessory]
                  (create-specific-cloud {:gen g
                                          :spec s
                                          :accessory acce
                                          :annot annot
                                          :cmnt cmnt}))))))))))
;; #+end_src

;; #+begin_src clojure
(defn create-clouds [& m]
  (domap create-specific-clouds m))
;; #+end_src

;; #developer comment:
;; Creating different clouds that exists in reality and combines
;; different genus, species and varieties

;; * Species

;; #+begin_src clojure
(create-clouds {
                :spec [FibratusCloud]
                :gen [CirrostratusCloud]
                }
)
(create-clouds {
                :spec [FibratusCloud NebulosusCloud]
                :gen [CirrostratusCloud]
                }
               {
                :spec [FibratusCloud UncinusCloud SpissatusCloud CastellanusCloud FloccusCloud]
                :gen [CirrusCloud]
                }
               {
                :spec [LenticularisCloud StratiformisCloud CastellanusCloud FloccusCloud]
                :gen [CirrocumulusCloud]
                }
               {
                :spec [LenticularisCloud StratiformisCloud CastellanusCloud FloccusCloud]
                :gen [CirrocumulusCloud AltocumulusCloud]
                }
               {
                :spec [LenticularisCloud StratiformisCloud CastellanusCloud]
                :gen [StratocumulusCloud]
                }
               {
                :spec [HumilisCloud MediocrisCloud CongestusCloud]
                :gen [CumulusCloud]
                }
               {
                :spec [CalvusCloud CapillatusCloud]
                :gen [CumulonimbusCloud]
                }
               {
                :spec [NebulosusCloud FractusCloud]
                :gen [StratusCloud]
                }
               )
;; #+end_src

;; * Varieties

;; #+begin_src clojure
(create-clouds {
                :var [DuplicatusCloud RadiatusCloud IntortusCloud VertebratusCloud]
                :spec [FibratusCloud]
                :gen [CirrusCloud]
                }
               {
                :var [DuplicatusCloud RadiatusCloud]
                :spec [UncinusCloud]
                :gen [CirrusCloud]
                }
               {
                :var [DuplicatusCloud UndulatusCloud]
                :spec [FibratusCloud]
                :gen [CirrostratusCloud]
                }
               {
                :var [UndulatusCloud]
                :spec [StratiformisCloud LenticularisCloud]
                :gen [CirrocumulusCloud]
                }
               {
                :var [LacunosusCloud]
                :spec [StratiformisCloud CastellanusCloud FloccusCloud]
                :gen [CirrocumulusCloud]
                }
               {
                :var [TranslucidusCloud PerlucidusCloud OpacusCloud
                      DuplicatusCloud UndulatusCloud RadiatusCloud LacunosusCloud]
                :spec [StratiformisCloud]
                :gen [AltocumulusCloud StratocumulusCloud]
                }
               {
                :var [DuplicatusCloud UndulatusCloud]
                :spec [LenticularisCloud]
                :gen [AltocumulusCloud StratocumulusCloud]
                }
               {
                :var [LacunosusCloud]
                :spec [CastellanusCloud FloccusCloud]
                :gen [AltocumulusCloud]
                }
               {
                :var [RadiatusCloud]
                :spec [HumilisCloud MediocrisCloud]
                :gen [CumulusCloud]
                }
               {
                :var [TranslucidusCloud OpacusCloud UndulatusCloud]
                :spec [NebulosusCloud]
                :gen [StratusCloud]
                }
               {
                :var [TranslucidusCloud OpacusCloud DuplicatusCloud UndulatusCloud RadiatusCloud]
                :gen [AltostratusCloud]
                }
               {
                :gen [StratocumulusCloud]
                :spec [CastellanusCloud]
                :var [LacunosusCloud]
                }
               )
;; #+end_src

;; * Genitus

;; #+begin_src clojure
(create-clouds {
                :var [CumulonimbogenitusCloud]
                :gen [CirrusCloud CirrostratusCloud AltocumulusCloud
                      AltostratusCloud NimbostratusCloud StratocumulusCloud]
                }
               {
                :var [CumulogenitusCloud]
                :gen [AltocumulusCloud CumulonimbusCloud NimbostratusCloud StratocumulusCloud]
                }
               {
                :var [AltocumulogenitusCloud]
                :gen [CirrusCloud AltostratusCloud CumulonimbusCloud StratusCloud]
                }
               {
                :var [NimbostratogenitusCloud]
                :gen [CumulonimbusCloud NimbostratusCloud]
                }
               {
                :var [StratocumulogenitusCloud]
                :gen [CumulonimbusCloud StratusCloud]
                }
               {
                :var [CirrocumulogenitusCloud]
                :gen [CirrusCloud CirrostratusCloud]
                }
               {
                :var [AltostratogenitusCloud]
                :gen [CumulonimbusCloud StratocumulusCloud]
                }
               {
                :var [AltocumulogenitusCloud StratocumulogenitusCloud]
                :spec [MediocrisCloud]
                :gen [CumulusCloud]
                }
               {
                :var [CumulogenitusCloud CumulonimbogenitusCloud NimbostratogenitusCloud]
                :spec [HumilisCloud]
                :gen [CumulusCloud]
                }
               )
;; #+end_src

;; *  Mutatus

;; #+begin_src clojure
(create-clouds {
                :var [StratomutatusCloud StratocumulomutatusCloud]
                :spec [MediocrisCloud]
                :gen [CumulusCloud]
                }
               {
                :var [StratocumulomutatusCloud]
                :spec [HumilisCloud]
                :gen [CumulusCloud]
                }
               {
                :var [StratocumulomutatusCloud]
                :gen [StratusCloud NimbostratusCloud]
                }
               {
                :var [StratomutatusCloud]
                :gen [StratusCloud StratocumulusCloud NimbostratusCloud AltocumulusCloud]
                }
               {
                :var [NimbostratomutatusCloud]
                :gen [StratocumulusCloud AltocumulusCloud AltostratusCloud]
                }
               {
                :var [AltocumulomutatusCloud]
                :gen [CirrocumulusCloud CirrostratusCloud NimbostratusCloud StratocumulusCloud]
                }
               {
                :var [CirrostratomutatusCloud]
                :gen [CirrusCloud CirrocumulusCloud  AltostratusCloud]
                }
               {
                :var [CirrocumulomutatusCloud]
                :gen [CirrostratusCloud AltocumulusCloud]
                }
               {
                :var [CirromutatusCloud]
                :gen [CirrostratusCloud CirrocumulusCloud]
                }
               {
                :var [AltostratomutatusCloud]
                :gen [AltocumulusCloud NimbostratusCloud]
                }
               {
                :var [CumulomutatusCloud]
                :gen [CumulonimbusCloud]
                }
               )
;; #+end_src

;; * Supplementary features

;; #+begin_src clojure
(create-clouds {
                :feature [PraecipitatioCloud]
                :gen [CumulusCloud]
                :spec [HumilisCloud]
                }
               {
                :feature [VirgaCloud]
                :gen [CirrocumulusCloud AltocumulusCloud AltostratusCloud
                      CumulonimbusCloud NimbostratusCloud StratocumulusCloud]
                }
               {
                :feature [VirgaCloud]
                :gen [CumulusCloud]
                :spec [CongestusCloud MediocrisCloud]
                }
               {
                :feature [PraecipitatioCloud]
                :gen [AltostratusCloud CumulonimbusCloud NimbostratusCloud StratocumulusCloud]
                }
               {
                :feature [MammaCloud]
                :gen [CirrusCloud CirrocumulusCloud AltocumulusCloud
                      AltostratusCloud CumulonimbusCloud StratocumulusCloud]
                }
               {
                :feature [VirgaCloud PraecipitatioCloud IncusCloud
                          MammaCloud ArcusCloud TubaCloud]
                :gen [CumulonimbusCloud]
                }
               {
                :feature [VirgaCloud PraecipitatioCloud MammaCloud ArcusCloud]
                :gen [CumulusCloud]
                :spec [CongestusCloud]
                }
               {
                :feature [VirgaCloud PraecipitatioCloud MammaCloud]
                :gen [CumulusCloud]
                :spec [MediocrisCloud]
                }
               )
;; #+end_src

;; * Accessory clouds

;; #+begin_src clojure
(create-clouds {
                :accessory [PannusCloud PileusCloud VelumCloud]
                :gen [CumulonimbusCloud]
                }
               {
                :accessory [PannusCloud PileusCloud VelumCloud]
                :gen [CumulusCloud]
                :spec [CongestusCloud]
                }
               {
                :accessory [PileusCloud VelumCloud]
                :gen [CumulusCloud]
                :spec [MediocrisCloud]
                }
               {
                :accessory [PannusCloud]
                :gen [AltostratusCloud NimbostratusCloud]
                }
               )
;; #+end_src

;; #developer comment:
;; Creating clouds with more than a variety with their annotation

;; #+begin_src clojure
(doseq [opacity [TranslucidusCloud PerlucidusCloud OpacusCloud]
        pattrn  [RadiatusCloud DuplicatusCloud UndulatusCloud LacunosusCloud]
        gen [AltocumulusCloud StratocumulusCloud]
        ]
  (let [v (cond
            (= gen AltocumulusCloud)
            (cond
              (= pattrn RadiatusCloud)
              (cond
                (= opacity TranslucidusCloud) 30
                (= opacity PerlucidusCloud) 31
                (= opacity OpacusCloud) 32
                )
              (= pattrn DuplicatusCloud)
              (cond
                (= opacity TranslucidusCloud) 33
                (= opacity PerlucidusCloud) 34
                (= opacity OpacusCloud) 35
                )
              (= pattrn UndulatusCloud)
              (cond
                (= opacity TranslucidusCloud) 37
                (= opacity PerlucidusCloud) 38
                (= opacity OpacusCloud) 39
                )
              (= pattrn LacunosusCloud)
              (cond
                (= opacity TranslucidusCloud) 41
                (= opacity PerlucidusCloud) 42
                (= opacity OpacusCloud) 43
                ))
            (= gen StratocumulusCloud)
            (cond
              (= pattrn RadiatusCloud)
              (cond
                (= opacity TranslucidusCloud) 66
                (= opacity PerlucidusCloud) 67
                (= opacity OpacusCloud) 68
                )
              (= pattrn DuplicatusCloud)
              (cond
                (= opacity TranslucidusCloud) 69
                (= opacity PerlucidusCloud) 70
                (= opacity OpacusCloud) 71
                )
              (= pattrn UndulatusCloud)
              (cond
                (= opacity TranslucidusCloud) 73
                (= opacity PerlucidusCloud) 74
                (= opacity OpacusCloud) 75
                )
              (= pattrn LacunosusCloud)
              (cond
                (= opacity TranslucidusCloud) 77
                (= opacity PerlucidusCloud) 78
                (= opacity OpacusCloud) 79
                )
              ))
        link (if (< v 44) "https://en.wikipedia.org/wiki/List_of_cloud_types#Middle_.C3.A9tage_stratocumuliform.2C_cumuliform.2C_and_stratiform"
                 "https://en.wikipedia.org/wiki/List_of_cloud_types#cite_ref-clouds_-_species_and_varieties_6-15")
        ]
    (cloud {:genusCloud gen
            :speciesCloud StratiformisCloud
            :varietyCloudVector  [opacity pattrn]
            :coment (str "A cloud with 2 varieties (opacity-based and pattern-based)."
                         "V-" v
                         "at " link)
            :annot  [link]})))
(doseq [opacity [TranslucidusCloud OpacusCloud]
        pattrn  [RadiatusCloud DuplicatusCloud UndulatusCloud]]
  (let [v
        (cond
              (= pattrn RadiatusCloud)
              (cond
                (= opacity TranslucidusCloud) 49
                (= opacity OpacusCloud) 50
                )
              (= pattrn DuplicatusCloud)
              (cond
                (= opacity TranslucidusCloud) 51
                (= opacity OpacusCloud) 52
                )
              (= pattrn UndulatusCloud)
              (cond
                (= opacity TranslucidusCloud) 53
                (= opacity OpacusCloud) 54
                )
              )
        link "https://en.wikipedia.org/wiki/List_of_cloud_types#cite_ref-Aerographer2012_7-12"
        ]
  (cloud {:genusCloud AltostratusCloud
          :varietyCloudVector  [opacity pattrn]
          :coment (str "A cloud with 2 varieties (opacity-based and pattern-based)."
                         "V-" v
                         "at " link)
          :annot [link]})))
(doseq [opacity [TranslucidusCloud OpacusCloud]]
  (let [v (cond
            (= opacity TranslucidusCloud) 87
            (= opacity OpacusCloud) 88
            )
        link "https://en.wikipedia.org/wiki/List_of_cloud_types#cite_ref-Aerographer2012_7-19"
        ]
  (cloud {:genusCloud AltostratusCloud
          :varietyCloudVector  [opacity UndulatusCloud]
          :coment (str "A cloud with 2 varieties (opacity-based and pattern-based)."
                         "V-" v
                         "at " link)
          :annot [link]})))
;; #+end_src

;; * Annotations

;; ** Pronunciation Annotation

;; developer comment:
;; Pronunciation annotations (click on the listen button in google translate)
;; Creating a pronunciation function:

;; #+begin_src clojure
(defn prnc [cls]
  (let [clsString (l/resolve-entity cls)
        searchString (str/replace-first(str/replace clsString #"[A-Z]+" #(str "+" %1)) "+" "")]
    (refine cls :annotation (pronounce (str "https://translate.google.co.uk/#la/en/"
                                               searchString)))))

(defn addPrnc [& cls]
  (domap prnc (flatten (for [x (map subclasses cls)]
                             (for [cls x]
                               cls)))))
;; #+end_src

;; developer comment:
;; We need the reasoner to create all the clouds before adding their pronunciation

;; #+begin_src clojure
(r/reasoner-factory :hermit)
;; #+end_src

;; developer comment:
;; Adding the pronunciation annotations

;; #+begin_src clojure
(addPrnc AltitudeLevel
         AtmosphericLayer
         Genus
         Species
         Form
         AccessoryCloud
         SupplementaryFeature)

(apply addPrnc (direct-subclasses Variety))
;; #+end_src


;; #+begin_comment
;; #+begin_src clojure
;; (let [allClasses (r/issubclasses (owl-thing))]
;; (print allClasses (count allClasses))
;; (domap prnc allClasses))
;; #+end_src
;; #+end_comment


;; ** Symbol Annotation

;; developer comment:
;; Creating a symbol function:

;; #+begin_src clojure
(defn sym [cls symbl] (refine cls :annotation (with-symbol symbl)))
;; #+end_src

;; developer comment:
;; Adding the symbol annotations

;; *** Genus

;; #+begin_src clojure
(sym Altocumulus "Ac")
(sym Altostratus "As")
(sym Cirrocumulus "Cc")
(sym Cirrostratus "Cs")
(sym Cirrus "Ci")
(sym Cumulonimbus "Cb")
(sym Cumulus "Cu")
(sym Nimbostratus "Ns")
(sym Stratocumulus "Sc")
(sym Stratus "St")
;; #+end_src

;; *** Species

;; #+begin_src clojure
(sym Calvus "Cal")
(sym Capillatus "Cap")
(sym Castellanus "Cas")
(sym Congestus "Con")
(sym Fibratus "Fib")
(sym Floccus "Flo")
(sym Fractus "Fra")
(sym Humilis "Hum")
(sym Lenticularis "Len")
(sym Mediocris "Med")
(sym Nebulosus "Neb")
(sym Spissatus "Spi")
(sym Stratiformis "Str")
(sym Uncinus "Unc")
;; #+end_src

;; *** Varieties

;; #+begin_src clojure
(sym Opacus "Opa")
(sym Perlucidus "Per")
(sym Translucidus "Tra")
(sym Duplicatus "Dup")
(sym Intortus "Int")
(sym Lacunosus "Lan")
(sym Radiatus "Rad")
(sym Undulatus "Und")
(sym Vertebratus "Ver")
;; #+end_src

;; *** Mother clouds

;; #+begin_src clojure
(sym Genitus "gen")
(sym Mutatus "mut")
;; #+end_src

;; ** Photos Annotations

;; developer comment:
;; Creating an img function:

;; #+begin_src clojure
(defn img [cls pic] (refine cls :annotation (photo pic)))
;; #+end_src

;; developer comment:
;; Adding the img annotations

;; #+begin_src clojure
(img Genus "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cloud_types_en.svg")
(img Noctilucent "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Helkivad_%C3%B6%C3%B6pilved_Kuresoo_kohal.jpg")
(img Nacreous "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Nacreous_clouds_Antarctica.jpg")
(img CirrusUncinusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrus_clouds2.jpg")
(img CirrusSpissatusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:CirrusField-color.jpg")
(img CirrusFibratusRadiatusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Tadrart01.JPG")
(img CirrocumulusStratiformisCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrocumulus_in_Hong_Kong.jpg")
(img CirrostratusNebulosusCloud  "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrostratus_fibratus.jpg")
(img AltostratusTranslucidusCloud  "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrostratus_fibratus.jpg")
(img AltocumulusFloccusCloud  "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Altocumulus.jpg")
(img AltocumulusCastellanusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Altocumulus-Castellanus.jpg")
(img AltocumulusLenticularisDuplicatusCloud  "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Saucer_cloud_over_Campbell_Mesa,_AZ.jpg")
(img AltocumulusStratiformisUndulatusCloud  "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Altocumulus_undulatus_cloud.jpg")
(img AltocumulusStratiformisTranslucidusLacunosusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:HolePunchCloud.jpg")
(img AltocumulusStratiformisPerlucidusUndulatusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrus_and_Altostratus_undulatus.JPG")
(img AltostratusOpacusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrus_and_Altostratus_undulatus.JPG")
(img CirrusFibratusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cirrus_and_Altostratus_undulatus.JPG")
(img AltostratusTranslucidusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:As_1.jpg")
(img AltostratusOpacusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:As_1.jpg")
(img CumulonimbusCalvusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Wagga-Cumulonimbus.jpg")
(img CumulonimbusCapillatusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cumulonimbus-incus_mykonos.jpg")
(img CumulusCongestusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cumulus_congestus_cloud.jpg")
(img NimbostratusVirgaCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Nimbostratus_virga.JPG")
(img CumulusMediocrisCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Above_the_Clouds.jpg")
(img CumulusMediocrisPileusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Cumulus_pileus.jpg")
(img StratocumulusCastellanusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Stratocumulus_castellanus_break_2.JPG")
(img StratocumulusCumulogenitusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Clouds_CL4.jpg")
(img AltocumulusStratiformisCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Clouds_CL4.jpg")
(img CumulusHumilisCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Sielec_009-Sielec_011.jpg")
(img StratusNebulosusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Stratus-Cloud-Uetliberg.jpg")
(img StratusFractusCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Povazsky01.jpg")
(img AltocumulusLenticularisCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Wavecloud.jpg")
(img Mamma "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Mammatussquawvalley.jpg")
(img Mammatus "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Mammatussquawvalley.jpg")
(img MammaCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Mammatussquawvalley.jpg")
(img RollCloud "https://en.wikipedia.org/wiki/List_of_cloud_types#/media/File:Roll-Cloud-Racine.jpg")
;; #+end_src

;; developer comment:
;; Creating new informal terms for their equivalent formal terms

;; developer comment:
;; Creating an informal function:

;; #+begin_src clojure
(defn informal [formalTerm & informalTerms ]
  (as-equivalent formalTerm informalTerms)
  (dofor [term informalTerms]
          (refine term
                     :comment (str "An informal term for "
                                   (l/resolve-entity formalTerm)
                                   " from https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_and_informal_terms_related_to_free-convective_cloud_types_and_storms")
                     :annotation (related formalTerm) (ref-link "https://en.wikipedia.org/wiki/List_of_cloud_types#WMO_and_informal_terms_related_to_free-convective_cloud_types_and_storms"))))
;; #+end_src

;; developer comment:
;; Adding the informal terms

;; #+begin_src clojure
(declare-classes Anvil AnvilDome CloudTags Collar CondensationFunnel
                 Knuckles Scud Shelf Striations)
(informal Incus Anvil AnvilDome)
(informal Fractus CloudTags Scud)
(informal Velum Collar Striations)
(informal Tuba CondensationFunnel)
(informal Mamma Knuckles)
(informal Arcus Shelf)
;; #+end_src

;; developer comment:
;; save the ontology

;; #+begin_src clojure
(save-ontology "clouds-ontology.omn" :omn)
(save-ontology "clouds-ontology.owl" :owl)
;; #+end_src

;; # Local Variables:
;; # lentic-init: lentic-clojure-org-init
;; # End:
