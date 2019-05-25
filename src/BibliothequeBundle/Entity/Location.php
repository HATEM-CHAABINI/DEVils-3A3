<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Location
 *
 * @ORM\Table(name="location")
 * @ORM\Entity(repositoryClass="BibliothequeBundle\Repository\LocationRepository")
 */
class Location
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_location", type="date", nullable=false)
     */
    private $dateLocation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_retour", type="date", nullable=false)
     */
    private $dateRetour;


    /**
     * @ORM\ManyToOne(targetEntity="AppBundle\Entity\User")
     * @ORM\JoinColumn(name="locataire", referencedColumnName="id")
     */
    private $Locataire;

    /**
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumn(name="livre", referencedColumnName="id")
     */
    private $Livre;

    /**
     * @var string
     *
     * @ORM\Column(name="Etat", type="string", length=255, nullable=false)
     */
    private $etat;

    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set dateLocation
     *
     * @param \DateTime $dateLocation
     *
     * @return Location
     */
    public function setDateLocation($dateLocation)
    {
        $this->dateLocation = $dateLocation;

        return $this;
    }

    /**
     * Get dateLocation
     *
     * @return \DateTime
     */
    public function getDateLocation()
    {
        return $this->dateLocation;
    }

    /**
     * Set dateRetour
     *
     * @param \DateTime $dateRetour
     *
     * @return Location
     */
    public function setDateRetour($dateRetour)
    {
        $this->dateRetour = $dateRetour;

        return $this;
    }

    /**
     * Get dateRetour
     *
     * @return \DateTime
     */
    public function getDateRetour()
    {
        return $this->dateRetour;
    }

    /**
     * Set locataire
     *
     * @param \AppBundle\Entity\User $locataire
     *
     * @return Location
     */
    public function setLocataire(\AppBundle\Entity\User $locataire = null)
    {
        $this->Locataire = $locataire;

        return $this;
    }

    /**
     * Get locataire
     *
     * @return \AppBundle\Entity\User
     */
    public function getLocataire()
    {
        return $this->Locataire;
    }

    /**
     * Set livre
     *
     * @param \BibliothequeBundle\Entity\Livre $livre
     *
     * @return Location
     */
    public function setLivre(\BibliothequeBundle\Entity\Livre $livre = null)
    {
        $this->Livre = $livre;

        return $this;
    }

    /**
     * Get livre
     *
     * @return \BibliothequeBundle\Entity\Livre
     */
    public function getLivre()
    {
        return $this->Livre;
    }

    /**
     * Set etat
     *
     * @param string $etat
     *
     * @return Location
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }
}
