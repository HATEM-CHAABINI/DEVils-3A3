<?php

namespace EventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement")
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idEvent", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idevent;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=255, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateD", type="date", nullable=false)
     */
    private $dated;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateF", type="date", nullable=false)
     */
    private $datef;

    /**
     * @var string
     *
     * @ORM\Column(name="salle", type="string", length=10, nullable=false)
     */
    private $salle;

    /**
     * @var float
     *
     * @ORM\Column(name="prixEnfant", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixenfant;

    /**
     * @var float
     *
     * @ORM\Column(name="prixAdulte", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixadulte;

    /**
     * @var float
     *
     * @ORM\Column(name="prixEtudiant", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixetudiant;

    /**
     * @var string
     *
     * @ORM\Column(name="time", type="string", length=30, nullable=false)
     */
    private $time;

    /**
     * @var string
     *
     * @ORM\Column(name="typeEvent", type="string", length=30, nullable=false)
     */
    private $typeevent;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=255, nullable=false)
     */
    private $image;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbrPlace", type="integer", nullable=false)
     */
    private $nbrplace;



    /**
     * Get idevent
     *
     * @return integer
     */
    public function getIdevent()
    {
        return $this->idevent;
    }

    /**
     * Set titre
     *
     * @param string $titre
     *
     * @return Evenement
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Evenement
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set dated
     *
     * @param \DateTime $dated
     *
     * @return Evenement
     */
    public function setDated($dated)
    {
        $this->dated = $dated;

        return $this;
    }

    /**
     * Get dated
     *
     * @return \DateTime
     */
    public function getDated()
    {
        return $this->dated;
    }

    /**
     * Set datef
     *
     * @param \DateTime $datef
     *
     * @return Evenement
     */
    public function setDatef($datef)
    {
        $this->datef = $datef;

        return $this;
    }

    /**
     * Get datef
     *
     * @return \DateTime
     */
    public function getDatef()
    {
        return $this->datef;
    }

    /**
     * Set salle
     *
     * @param string $salle
     *
     * @return Evenement
     */
    public function setSalle($salle)
    {
        $this->salle = $salle;

        return $this;
    }

    /**
     * Get salle
     *
     * @return string
     */
    public function getSalle()
    {
        return $this->salle;
    }

    /**
     * Set prixenfant
     *
     * @param float $prixenfant
     *
     * @return Evenement
     */
    public function setPrixenfant($prixenfant)
    {
        $this->prixenfant = $prixenfant;

        return $this;
    }

    /**
     * Get prixenfant
     *
     * @return float
     */
    public function getPrixenfant()
    {
        return $this->prixenfant;
    }

    /**
     * Set prixadulte
     *
     * @param float $prixadulte
     *
     * @return Evenement
     */
    public function setPrixadulte($prixadulte)
    {
        $this->prixadulte = $prixadulte;

        return $this;
    }

    /**
     * Get prixadulte
     *
     * @return float
     */
    public function getPrixadulte()
    {
        return $this->prixadulte;
    }

    /**
     * Set prixetudiant
     *
     * @param float $prixetudiant
     *
     * @return Evenement
     */
    public function setPrixetudiant($prixetudiant)
    {
        $this->prixetudiant = $prixetudiant;

        return $this;
    }

    /**
     * Get prixetudiant
     *
     * @return float
     */
    public function getPrixetudiant()
    {
        return $this->prixetudiant;
    }

    /**
     * Set time
     *
     * @param string $time
     *
     * @return Evenement
     */
    public function setTime($time)
    {
        $this->time = $time;

        return $this;
    }

    /**
     * Get time
     *
     * @return string
     */
    public function getTime()
    {
        return $this->time;
    }

    /**
     * Set typeevent
     *
     * @param string $typeevent
     *
     * @return Evenement
     */
    public function setTypeevent($typeevent)
    {
        $this->typeevent = $typeevent;

        return $this;
    }

    /**
     * Get typeevent
     *
     * @return string
     */
    public function getTypeevent()
    {
        return $this->typeevent;
    }

    /**
     * Set image
     *
     * @param string $image
     *
     * @return Evenement
     */
    public function setImage($image)
    {
        $this->image = $image;

        return $this;
    }

    /**
     * Get image
     *
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * Set nbrplace
     *
     * @param integer $nbrplace
     *
     * @return Evenement
     */
    public function setNbrplace($nbrplace)
    {
        $this->nbrplace = $nbrplace;

        return $this;
    }

    /**
     * Get nbrplace
     *
     * @return integer
     */
    public function getNbrplace()
    {
        return $this->nbrplace;
    }
}
